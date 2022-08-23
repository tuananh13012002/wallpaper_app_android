package com.example.asm_anhdroidnetworking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.asm_anhdroidnetworking.Model.Photo;
import com.example.asm_anhdroidnetworking.OnListener;
import com.example.asm_anhdroidnetworking.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FPhotoAdapter extends RecyclerView.Adapter<FPhotoAdapter.FPhotoViewHolder> {
    private Context context;
    private List<Photo> list;
    private OnListener onListener;


    public FPhotoAdapter(Context context, List<Photo> list, OnListener onListener) {
        this.context = context;
        this.list = list;
        this.onListener = onListener;
        notifyDataSetChanged();
    }

    public void setList(List<Photo> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public FPhotoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new FPhotoViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FPhotoAdapter.FPhotoViewHolder holder, int position) {
        Photo photo = list.get(position);
        Glide.with(context).load(photo.getUrlO()).sizeMultiplier(0.5f).placeholder(R.drawable.l).into(holder.img);
        holder.txtView.setText(photo.getViews());
        holder.layoutItem.setOnClickListener(view -> {
            onListener.OnClickShowImage(photo, position);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FPhotoViewHolder extends RecyclerView.ViewHolder {
        private CardView layoutItem;
        private ImageView img;
        private TextView txtView;

        public FPhotoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layoutItem);
            img = itemView.findViewById(R.id.img);
            txtView = itemView.findViewById(R.id.txtView);
        }
    }

}
