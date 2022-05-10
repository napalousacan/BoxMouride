package com.acangroup.mouride.retrofit;
import com.acangroup.mouride.model.ApiResponse;
import com.acangroup.mouride.model.ApiResponseData;
import com.acangroup.mouride.model.ApiResponseDirect;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("thiesprestigejson.php")
    Call<ApiResponse> GetLink();

    @GET("listAndroid/albayanetv/json")
    Call<ApiResponseData> GetData();

    @GET("")
    Call<ApiResponseDirect> GetAllDirect(String url);
}


