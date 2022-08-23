package com.example.asm_anhdroidnetworking.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.asm_anhdroidnetworking.Model.Photo;
import com.example.asm_anhdroidnetworking.R;
import com.github.chrisbanes.photoview.PhotoView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageAdapter extends PagerAdapter {
    private Context context;
    private List<Photo> list;

    public ImageAdapter(Context context, List<Photo> list) {
        this.context = context;
        this.list = list;
    }
    public void setList(List<Photo> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view==object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        PhotoView imageView=new PhotoView(context);
        Photo photo = list.get(position);
        Glide.with(context).load(photo.getUrlO()).placeholder(R.drawable.l).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
       container.removeView((View) object);
    }
}
