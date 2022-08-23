package com.example.asm_anhdroidnetworking.View;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.asm_anhdroidnetworking.Adapter.ImageAdapter;
import com.example.asm_anhdroidnetworking.Data.FlickrService;
import com.example.asm_anhdroidnetworking.Data.MyRetrofitBuilder;
import com.example.asm_anhdroidnetworking.MainActivity;
import com.example.asm_anhdroidnetworking.Model.FPhoto;
import com.example.asm_anhdroidnetworking.Model.Photo;
import com.example.asm_anhdroidnetworking.Model.Photos;
import com.example.asm_anhdroidnetworking.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImageActivity extends AppCompatActivity {

    private PhotoView img;
    private FloatingActionButton fab3;
    private FloatingActionButton fab2;
    private FloatingActionButton fab1;
    private FloatingActionButton fab;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    private TextView txt3;
    private TextView txt2;
    private TextView txt1;
    private ViewPager viewPager;
    public static final int REQUEST_CODE = 0;
    private List<Photo> list;
    private ImageAdapter adapter;
    private Photo mPhoto;

    private static final String FULL_EXTRAS = "description, license, date_upload, date_taken, owner_name, icon_server, original_format, last_update, geo, tags, machine_tags, o_dims, views, media, path_alias, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o";
    private static final String USER_ID = "196084485@N03";
    private static final String KEY_TOKEN = "3864e6871249d02a2daa4017d097987c";
    private static final String GET_FAVOURITE = "flickr.favorites.getList";
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image);
        initView();
        list = new ArrayList<>();
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forword);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backforword);
        fab.setOnClickListener(view -> {
            animateFab();
        });

//        Photo photo = (Photo) getIntent().getSerializableExtra(MainActivity.KEY_IMAGE);
        int position =  getIntent().getIntExtra("position", -1);
//        if (photo != null) {
//            Glide.with(this).load(photo.getUrlO()).placeholder(R.drawable.l).into(img);
//        }
//        String imageUrlO = photo.getUrlO();
//        String imageUrlL = photo.getUrlL();
//        String imageUrlC = photo.getUrlC();
        fab3.setOnClickListener(view -> {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.e("Permission error", "You have permission");
                downloadImage("Download", mPhoto.getUrlO());
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        });

        fab2.setOnClickListener(view -> {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.e("Permission error", "You have permission");
                downloadImage("Download", mPhoto.getUrlL());
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        });
        fab1.setOnClickListener(view -> {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.e("Permission error", "You have permission");
                downloadImage("Download", mPhoto.getUrlC());
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        });

        Call<FPhoto> call = MyRetrofitBuilder.getInstance().create(FlickrService.class).getListFav(GET_FAVOURITE,
                KEY_TOKEN, USER_ID, FULL_EXTRAS, 50, page, "json",
                "1");
        adapter = new ImageAdapter(getApplicationContext(), list);
        viewPager.setAdapter(adapter);
        call.enqueue(new Callback<FPhoto>() {
            @Override
            public void onResponse(Call<FPhoto> call, Response<FPhoto> response) {
                FPhoto fPhoto = response.body();
                list = fPhoto.getPhotos().getPhoto();
                adapter.setList(list);
                viewPager.setCurrentItem(position, false);
            }

            @Override
            public void onFailure(Call<FPhoto> call, Throwable t) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                mPhoto = list.get(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void downloadImage(String fileName, String imageUrl) {
        try {
            DownloadManager downloadManager = null;
            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(imageUrl);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                    | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(fileName)
                    .setMimeType("image/jpeg")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + fileName);

            downloadManager.enqueue(request);
            Toast.makeText(this, "Download thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("abcccc", e.toString());
            Toast.makeText(this, "Download thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    private void animateFab() {
        if (isOpen) {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            txt1.setVisibility(View.GONE);
            txt2.setVisibility(View.GONE);
            txt3.setVisibility(View.GONE);
            txt1.setClickable(false);
            txt2.setClickable(false);
            txt3.setClickable(false);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen = false;
        } else {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            txt1.setVisibility(View.VISIBLE);
            txt2.setVisibility(View.VISIBLE);
            txt3.setVisibility(View.VISIBLE);
            txt1.setClickable(true);
            txt2.setClickable(true);
            txt3.setClickable(true);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen = true;
        }
    }


    private void initView() {
        img = findViewById(R.id.img);
        fab3 = findViewById(R.id.fab3);
        fab2 = findViewById(R.id.fab2);
        fab1 = findViewById(R.id.fab1);
        fab = findViewById(R.id.fab);
        txt3 = findViewById(R.id.txt3);
        txt2 = findViewById(R.id.txt2);
        txt1 = findViewById(R.id.txt1);
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.slide_down,R.anim.no_anim);
    }
}