package com.me.recyclerview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.recyclerview.R;
import com.me.recyclerview.model.SectionCollection;
import com.me.recyclerview.ui.adapter.MainAdapter;
import com.me.recyclerview.util.NewGenerator;
import com.me.recyclerview.volley.VolleyManager;

import org.json.JSONArray;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Braulio on 26/03/2016.
 */
public class MainFragment extends Fragment implements VolleyManager.OnRequestListener{

    private VolleyManager mVolleyManager;
    private MainAdapter mainAdapter;
    private SectionCollection   sectionCollection;

    @Bind(R.id.main_recycler) RecyclerView recyclerView;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVolleyManager = VolleyManager.getInstance(getActivity());
        mVolleyManager.setOnRequestListener(this);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onRequestSuccess(JSONArray responseArray) {

    }

    @Override public void onRequestSuccess(final JSONObject responseObject) {
        Log.i("MainFragment", responseObject.toString());
        new Thread(){
            @Override
            public void run() {
                sectionCollection = NewGenerator.getSectionCollection(responseObject);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setUpRecyclerView();
                    }
                });
            }
        }.start();
    }

    @Override public void onRequestFail(Error error) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mVolleyManager.executeGetRequest("http://api.nytimes.com/svc/topstories/v1/business.json?api-key=a35f85751a35df3d0d93a700bf0204fd:9:74583509");

    }

    private void setUpRecyclerView(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mainAdapter = new MainAdapter(getContext(), getParentFragment(), sectionCollection.sections);
        recyclerView.setAdapter(mainAdapter);
    }
}
