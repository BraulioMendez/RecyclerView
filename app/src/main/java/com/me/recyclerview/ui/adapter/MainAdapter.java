package com.me.recyclerview.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.me.recyclerview.R;
import com.me.recyclerview.model.Section;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Braulio on 27/03/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Section> dataList;
    private Context context;

    public MainAdapter(Context context, Fragment fragment, List<Section> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() { return dataList.size(); }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_main_fragment, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Section dataItem = this.dataList.get(position);

        Glide.with(context)
                .load(dataItem.url).into(holder.mainImage);

        holder.titleText.setText(dataItem.title);
        holder.infoText.setText(dataItem.info);
        holder.sectionText.setText(dataItem.section);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.container_holder)
        ViewGroup containerHolder;
        @Bind(R.id.main_image)
        ImageView mainImage;
        @Bind(R.id.info_text)
        TextView infoText;
        @Bind(R.id.title_text)
        TextView titleText;
        @Bind(R.id.section_text)
        TextView sectionText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
