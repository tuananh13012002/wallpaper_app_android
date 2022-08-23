package com.example.asm_anhdroidnetworking.Data;

import com.example.asm_anhdroidnetworking.Model.FPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {

    @GET("services/rest/")
    Call<FPhoto> getListFav(@Query("method") String method,
                                  @Query("api_key") String api_key,
                                  @Query("user_id") String user_id,
                                  @Query("extras") String extras,
                                  @Query("per_page") int page_page,
                                  @Query("page") int page,
                                  @Query("format") String format,
                                  @Query("nojsoncallback") String nojsoncallback
                                  );

}
