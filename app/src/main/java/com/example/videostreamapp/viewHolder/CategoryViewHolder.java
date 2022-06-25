package com.example.videostreamapp.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videostreamapp.R;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryTv;
    private RecyclerView videoRV;
    private Context context;

    public TextView getCategoryTv() {
        return categoryTv;
    }

    public void setCategoryTv(String category) {
        this.categoryTv.setText(category);
    }

    public RecyclerView getVideoRV() {
        return videoRV;
    }

    public void setVideoRV(FirestorePagingAdapter adapter,RecyclerView.LayoutManager layoutManager) {
        this.videoRV.setLayoutManager(layoutManager);
        this.videoRV.setAdapter(adapter);
    }

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryTv=itemView.findViewById(R.id.idTVcategori);
        videoRV=itemView.findViewById(R.id.idRVVideos);
    }
}
