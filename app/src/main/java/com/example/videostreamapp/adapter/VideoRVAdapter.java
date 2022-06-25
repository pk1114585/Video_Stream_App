package com.example.videostreamapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videostreamapp.R;
import com.example.videostreamapp.VideoDisplayActivity;
import com.example.videostreamapp.data.VideoRVModel;
import com.example.videostreamapp.viewHolder.VideoViewHolder;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;

public class VideoRVAdapter extends FirestorePagingAdapter<VideoRVModel,VideoViewHolder> {
    private ImageView videoIV;
    /**
     * Construct a new FirestorePagingAdapter from the given {@link FirestorePagingOptions}.
     *
     * @param options
     */
    public VideoRVAdapter(@NonNull FirestorePagingOptions<VideoRVModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull VideoViewHolder holder, int position, @NonNull VideoRVModel model) {
      videoIV=holder.itemView.findViewById(R.id.idIVVideo);
      String thumburl="http://img.youtube.com/vi"+model.getVideoId()+"/hqdefault.jpg";
      holder.setVideoIV(thumburl);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(holder.itemView.getContext(), VideoDisplayActivity.class);
              intent.putExtra("videoTitle",model.getVideoTitle());
              intent.putExtra("videoCategory",model.getVideoCategory());
              intent.putExtra("videoDesc",model.getVideoDescreption());
              intent.putExtra("videoId",model.getVideoId());
              holder.itemView.getContext().startActivity(intent);

          }
      });
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rv_item,parent,false);
        return new VideoViewHolder(view);
    }
}
