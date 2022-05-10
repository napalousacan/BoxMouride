package com.acangroup.mouride;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.acangroup.mouride.model.ApiResponseData;
import com.acangroup.mouride.retrofit.APIService;
import com.acangroup.mouride.retrofit.ApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashScreen extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        checkInternetConnection();

        /*try {
            okhttp3.Response response = client.newCall(request).execute();
        } catch (IOException e){
            e.printStackTrace();
        }*/

    }

    private void checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
                NextActivity();

        } else {
            AlertDialog alert = new AlertDialog.Builder(SplashScreen.this).create();
            alert.setTitle("Alerte :");
            alert.setMessage("Une connexion à Internet est nécessaire pour accéder à l'application.");
            alert.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });
            alert.show();

        }
    }

    private void NextActivity() {
        Thread timer= new Thread(){
            public void run(){
                try{
                    sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    getLink();
                }
            }
        };
        timer.start();
    }

    void getLink(){

        Request request = new Request.Builder()
                //.url("https://acanvod.acan.group/myapiv2/listLiveTV/albayanetv/json")
                .url("https://acangroup.org/aar/mouride24/mouride24boxtv.json")
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {
                if (response.isSuccessful()){
                    ResponseBody responseBody=response.body();

                    try {
                        final String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            JSONObject obj = new JSONObject(result);
                            JSONArray jsonArray = obj.getJSONArray("allitems");
                            String url_direct="";
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject row = jsonArray.getJSONObject(i);
                                Log.d("element json", row.toString());
                                Log.i("element", row.getString("stream_url"));
                                Log.i("condition", row.getString("read"));
                                if (row.getString("read").equals("yes"))
                                {
                                    url_direct = row.getString("stream_url");
                                    break;
                                }
                                else{
                                    Log.i("condition", "non");
                                }
                                /*if (row.getString("read").equals("yes")){
                                    url_direct = row.getString("stream_url");
                                    Log.d("dans if",url_direct);
                                }*/
                            }
                            ///Log.i("liste tv", String.valueOf(jsonArray));
                            //JSONObject row = jsonArray.getJSONObject(0);
                            //String url_direct = row.getString("stream_url");
                            //Analytical data
                            Log.d("json",url_direct);

                            Intent i = new Intent(getApplicationContext(), LiveTv.class);
                            assert response.body() != null;
                            i.putExtra("url", url_direct);
                            startActivity(i);
                            finish();

                        }
                    } catch (Exception e) {
                        //Log.d(TAG, "Exception = " + e);
                    }
                }
            }
        });



        /*APIService service = ApiClient.getClient().create(APIService.class);
        Call<ApiResponse> userCall = service.GetLink();

        userCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                    Intent i = new Intent(getApplicationContext(), LiveTv.class);
                    assert response.body() != null;
                    i.putExtra("url", response.body().getAllitems().get(0).getHlsUrl());
                    startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("onFailure", t.toString());

                showMessage("Attention","Probléme de connexion Internet !!!");
            }
        });*/
    }

    void getData(){
        APIService service = ApiClient.getClient().create(APIService.class);
        Call<ApiResponseData> userCall = service.GetData();

        userCall.enqueue(new Callback<ApiResponseData>() {
            @Override
            public void onResponse(Call<ApiResponseData> call, Response<ApiResponseData> response) {

                Intent i = new Intent(getApplicationContext(), LiveTv.class);
                assert response.body() != null;
                i.putExtra("url", response.body().getAllitems().get(0).getFeed_url());
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<ApiResponseData> call, Throwable t) {
                Log.d("onFailure", t.toString());

                showMessage("Attention","Probléme de connexion Internet !!!");
            }
        });
    }


    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }

}

