package com.sandhosh.estrradodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.sandhosh.estrradodemo.model.HomeResponseModel;
import com.sandhosh.estrradodemo.retrofitService.ApiServfices;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    ViewPager mViewPager;
   List<HomeResponseModel.BannerSlider> bannerSliders=new ArrayList<>();
        Spinner spinner;
     List<HomeResponseModel.Region>regionList=new ArrayList<>();
    List<String>regionNameList=new ArrayList<>();
    RecyclerView recyclerView,recyclerCategory;
    List<HomeResponseModel.Featured> featuredList=new ArrayList<>();
    List<HomeResponseModel.Category> categoryList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mViewPager = findViewById(R.id.viewPager);
        spinner=findViewById(R.id.spinner);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerCategory=findViewById(R.id.recyclerCategory);
        if (isNetworkAvailable()){
            getDatafromServer();
        }else
        {
            networkfailedMethod();
        }


    }

    private void networkfailedMethod() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Please Check your Internet Connection and try Again later....");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void getDatafromServer() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://estrradodemo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServfices service = retrofit.create(ApiServfices.class);
        service.homeMethod("406643", "AE").enqueue(new Callback<HomeResponseModel>() {
            @Override
            public void onResponse(Call<HomeResponseModel> call, Response<HomeResponseModel> response) {
                Log.e("response code", response.code() + " ");
                if (response.code() == 200) {
                    Log.e("response code", response.code() + " ");
                    HomeResponseModel loginResponse = response.body();
                    if (loginResponse != null && loginResponse.getData() != null) {
                        if (loginResponse.getData().getBannerSlider() != null)
                            bannerSliders.addAll(loginResponse.getData().getBannerSlider());
                        ImageAdapter adapterView = new ImageAdapter(MainActivity.this, bannerSliders);
                        mViewPager.setAdapter(adapterView);
                        if (loginResponse.getData().getRegions() != null) {
                            for (int a=0;a<loginResponse.getData().getRegions().size();a++){
                                regionNameList.add(loginResponse.getData().getRegions().get(a).getCountryName());
                            }
                            regionList.addAll(loginResponse.getData().getRegions());
                            spinnerMethod();
                        }
                        if (loginResponse.getData().getFeatured()!=null){
                            featuredList.addAll(loginResponse.getData().getFeatured());
                            LinearLayoutManager horizontalLayoutManager
                                    = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            recyclerView.setLayoutManager(horizontalLayoutManager);
                            MyRecyclerViewAdapter    adapter = new MyRecyclerViewAdapter(getApplicationContext(), featuredList);
                            recyclerView.setAdapter(adapter);
                        }
                        if (loginResponse.getData().getCategories()!=null){
                            categoryList.addAll(loginResponse.getData().getCategories());
                            LinearLayoutManager horizontalLayoutManager
                                    = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                            recyclerCategory.setLayoutManager(horizontalLayoutManager);
                            CategoryViewAdapter    adapter = new CategoryViewAdapter(getApplicationContext(), categoryList);
                            recyclerCategory.setAdapter(adapter);
                        }
                    }
                    progressDialog.dismiss();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Please try Again later...", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<HomeResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection failed please try Again later.... ", Toast.LENGTH_SHORT).show();
                call.cancel();
                t.printStackTrace();
                progressDialog.dismiss();
            }
        });

    }

    private void spinnerMethod() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, regionNameList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}