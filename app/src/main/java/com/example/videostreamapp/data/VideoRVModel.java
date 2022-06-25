package com.example.videostreamapp.data;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class VideoRVModel {
    private String videoTitle;
    private  String videoDescreption;
    private String videoId;
    private String videoCategory;
    @ServerTimestamp
    private Date timestamp;

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescreption() {
        return videoDescreption;
    }

    public void setVideoDescreption(String videoDescreption) {
        this.videoDescreption = videoDescreption;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public VideoRVModel(){

   }
}
