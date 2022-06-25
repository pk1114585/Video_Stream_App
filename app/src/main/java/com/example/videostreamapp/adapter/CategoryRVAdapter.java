package com.example.videostreamapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.paging.PagedList;

import com.example.videostreamapp.R;
import com.example.videostreamapp.data.CategoryRVModel;
import com.example.videostreamapp.data.VideoRVModel;
import com.example.videostreamapp.viewHolder.CategoryViewHolder;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class CategoryRVAdapter extends FirestorePagingAdapter<CategoryRVModel, CategoryViewHolder> {
    private TextView categoryTV;
    private Context context;
    private ProgressBar loadingPB;
    /**
     * Construct a new FirestorePagingAdapter from the given {@link FirestorePagingOptions}.
     *
     * @param options
     */
    public CategoryRVAdapter(@NonNull FirestorePagingOptions<CategoryRVModel> options,Context context,ProgressBar loadingPB) {
        super(options);
        this.context=context;
        this.loadingPB=loadingPB;
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull CategoryRVModel model) {

    }

    private Query getchildQuery(FirebaseFirestore firebaseFirestore, String category){
        com.google.firebase.firestore.Query query= firebaseFirestore.collection("Video").whereEqualTo("videoCategory",category);
      // query.orderBy("timestamp", Query.Direction.DESCENDING);
        query.orderBy("timestamp",com.google.firebase.firestore.Query.Direction.DESCENDING);
       return query;
    }

    private FirestorePagingOptions.Builder<VideoRVModel> getfirebasepaging(FirebaseFirestore firebaseFirestore, String category){
       //Query basequery= getchildQuery(firebaseFirestore,category);
        com.google.firebase.firestore.Query basequery=getchildQuery(firebaseFirestore,category);
        PagedList.Config config1=new PagedList.Config.Builder()
                .setEnablePlaceholders(true).setPrefetchDistance(15)
                .setPageSize(15).build();

        return new FirestorePagingOptions.Builder<VideoRVModel>()
                .setLifecycleOwner((LifecycleOwner) context)
                .setQuery(basequery,config1,VideoRVModel.class).build();


    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
       return new CategoryViewHolder(view);
    }
}
