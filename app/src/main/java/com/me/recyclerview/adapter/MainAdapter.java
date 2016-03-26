package com.me.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.me.recyclerview.R;

import butterknife.Bind;

/**
 * Created by Braulio on 26/03/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_container, parent, false);
        return new ViewHolder(view);

    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

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
        }
    }
}
