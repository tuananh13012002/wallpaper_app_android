package com.example.asm_anhdroidnetworking;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.asm_anhdroidnetworking.Adapter.FPhotoAdapter;
import com.example.asm_anhdroidnetworking.Data.FlickrService;
import com.example.asm_anhdroidnetworking.Data.MyRetrofitBuilder;
import com.example.asm_anhdroidnetworking.Model.FPhoto;
import com.example.asm_anhdroidnetworking.Model.Photo;
import com.example.asm_anhdroidnetworking.View.ImageActivity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private static final String FULL_EXTRAS = "description, license, date_upload, date_taken, owner_name, icon_server, original_format, last_update, geo, tags, machine_tags, o_dims, views, media, path_alias, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o";
    private static final String USER_ID = "196084485@N03";
    private static final String KEY_TOKEN = "3864e6871249d02a2daa4017d097987c";
    private static final String GET_FAVOURITE = "flickr.favorites.getList";
    public static final String KEY_IMAGE = "KEY_IMAGE";
    private int page = 1;
    private FPhotoAdapter adapter;
    private List<Photo> list;
    NetworkChangeListener net = new NetworkChangeListener();
    private SwipeRefreshLayout swipeRefresh;
    private ScrollView scrollView;
    private AppBarLayout appBarLayout;
    private Toolbar toobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();
        list = new ArrayList<>();
        adapter = new FPhotoAdapter(MainActivity.this, list, new OnListener() {
            @Override
            public void OnClickShowImage(Photo photo, int position) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra(KEY_IMAGE, photo);
                intent.putExtra("position", position);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        rv.smoothScrollToPosition(0);
        rv.setAdapter(adapter);
        Call<FPhoto> call = MyRetrofitBuilder.getInstance().create(FlickrService.class).getListFav(GET_FAVOURITE,
                KEY_TOKEN, USER_ID, FULL_EXTRAS, 50, page, "json",
                "1");
        call.enqueue(new Callback<FPhoto>() {
            @Override
            public void onResponse(Call<FPhoto> call, Response<FPhoto> response) {
                FPhoto fPhoto = response.body();
                list = fPhoto.getPhotos().getPhoto();
                adapter.setList(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FPhoto> call, Throwable t) {
                Log.d("abc", t.getMessage());
            }
        });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        swipeRefresh = findViewById(R.id.swipeRefresh);
        scrollView = findViewById(R.id.scrollView);
        appBarLayout = findViewById(R.id.appBarLayout);
        toobar = findViewById(R.id.toobar);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(net, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(net);
        super.onStop();
    }
}