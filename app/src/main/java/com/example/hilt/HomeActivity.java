package com.example.hilt;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hilt.water.Water;
import com.example.hilt.water.WaterViewTwo;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.google.gson.JsonElement;
import com.zhpan.bannerview.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {



    private WaterViewTwo mWaterView;

    private List<Water> mWaters = new ArrayList<>();

    {
        for (int i = 0; i <10; i++) {
            mWaters.add(new Water((int) (i + Math.random() * 4), "item" + i));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWaterView = findViewById(R.id.wv_water);
        mWaterView.setWaters(mWaters);
        new Thread(new Runnable() {
            @Override
            public void run() {
                new HttpClient.Builder()
                        .setApiUrl("banner/json")
                        .get()
                        .build().request(new BannerRequest<BannerBean>() {
                    @Override
                    public void onSuccess(BannerBean o) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(HomeActivity.this,o.getDesc(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public BannerBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result,BannerBean.class);
                    }

                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }
                });
            }
        }).start();
    }

    public void onRest(View view) {
        mWaterView.setWaters(mWaters);
    }

}