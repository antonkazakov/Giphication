package com.antonkazakov.giphication.ui.screens.gifList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.antonkazakov.giphication.R;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.ui.widgets.SquareImage;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class GifsAdapter extends RecyclerView.Adapter<GifsAdapter.GifsVH> {

    private List<GifEntity> gifEntities = new ArrayList<>();
    private GifItemClickListener gifItemClickListener;

    public GifsAdapter(GifItemClickListener gifItemClickListener) {
        this.gifItemClickListener = gifItemClickListener;
    }

    void setData(List<GifEntity> gifEntities) {
        this.gifEntities = gifEntities;
        notifyDataSetChanged();
    }

    @Override
    public GifsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GifsVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gifs_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GifsVH holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if (gifItemClickListener != null) {
                gifItemClickListener.onItemClicked(gifEntities.get(holder.getAdapterPosition()));
            }
        });
        if (gifEntities.get(position).isLiked()) {
            holder.imgLike.setText("LIKED");
        }
        if (gifEntities.get(position).isDisliked()) {
            holder.imgLike.setText("DISLIKED");
        }
        holder.imgLike.setText(gifEntities.get(holder.getAdapterPosition()).getLikes() + " likes");
        holder.imgDislike.setText(gifEntities.get(holder.getAdapterPosition()).getDislikes() + " dislikes");
//        if (!gifEntities.get(holder.getAdapterPosition()).isDisliked()
//                && !gifEntities.get(holder.getAdapterPosition()).isLiked()) {
//            holder.imgDislike.setClickable(true);
//            holder.imgLike.setClickable(true);
//            holder.imgDislike.setOnClickListener(v -> {
//                if (gifItemClickListener != null) {
//                    holder.imgLike.setText("DISLIKED");
//                    gifItemClickListener.onItemDisliked(gifEntities.get(holder.getAdapterPosition()));
//                    holder.imgDislike.setClickable(false);
//                    holder.imgLike.setClickable(false);
//                }
//            });
//            holder.imgLike.setOnClickListener(v -> {
//                if (gifItemClickListener != null) {
//                    holder.imgDislike.setText("LIKED");
//                    gifItemClickListener.onItemLiked(gifEntities.get(holder.getAdapterPosition()));
//                    holder.imgDislike.setClickable(false);
//                    holder.imgLike.setClickable(false);
//                }
//            });
//        }
        Glide.with(holder.itemView.getContext())
                .load(gifEntities.get(holder.getAdapterPosition()).getThumbnail())
                .dontAnimate()
                .centerCrop()
                .into(holder.squareImage);
    }

    @Override
    public int getItemCount() {
        return gifEntities.size();
    }

    public static class GifsVH extends RecyclerView.ViewHolder {

        @BindView(R.id.thumbnail)
        SquareImage squareImage;

        @BindView(R.id.btn_like)
        Button imgLike;

        @BindView(R.id.btn_dislike)
        Button imgDislike;

        public GifsVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface GifItemClickListener {

        void onItemClicked(GifEntity entity);

        void onItemLiked(GifEntity entity);

        void onItemDisliked(GifEntity entity);

    }

}
