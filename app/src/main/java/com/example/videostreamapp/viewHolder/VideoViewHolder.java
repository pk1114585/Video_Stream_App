package com.example.videostreamapp.viewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videostreamapp.R;
import com.squareup.picasso.Picasso;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public void setVideoIV(String imguri){
        Picasso.get().load(imguri).into(videoiv);
    }

    private ImageView videoiv;
    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoiv=itemView.findViewById(R.id.idIVVideo);
    }
}
