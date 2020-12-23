package com.example.hilt;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.haozhang.lib.SlantedTextView;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.RequestCallback;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    Bean bean;
    private Button btn_ok;
    private RecyclerView rv;

    @Inject
    MyTitleAdapter myTitleAdapter;
    @Inject
    MyBodyAdapter myBodyAdapter;
    private SlantedTextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        bean.setErrorMsg("哈哈哈哈");
        String errorMsg = bean.getErrorMsg();
        Log.e("errorMsg", "onCreate: " + errorMsg);
    }

    private void initView() {
//        btn_ok = (Button) findViewById(R.id.btn_ok);
//        btn_ok.setOnClickListener(this);
//        rv = (RecyclerView) findViewById(R.id.rv);
//        MergeAdapter mergeAdapter = new MergeAdapter(myTitleAdapter, myBodyAdapter);
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(mergeAdapter);
//
//        test = (SlantedTextView) findViewById(R.id.test);
//        test.setText("哈哈哈哈")
//                .setTextSize(10)
//                .setSlantedLength(40)
//                .setSlantedBackgroundColor(R.color.permissionx_text_color)
//                .setTextColor(R.color.colorAccent)
//                .setMode(SlantedTextView.MODE_RIGHT);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_ok:
//                SelfDialog selfDialog = new SelfDialog(MainActivity.this);
//                selfDialog.setTitle("标题");
//                selfDialog.setMessage("提示");
//                selfDialog.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
//                    @Override
//                    public void onNoClick() {
//                        Toast.makeText(MainActivity.this, "取消" , Toast.LENGTH_SHORT).show();
//                    }
//                });
//                selfDialog.show();
//                PermissionX.init(this)
//                        .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CALENDAR)
//                        .onExplainRequestReason((scope, deniedList) -> {
//                            scope.showRequestReasonDialog(deniedList, "这个权限是必要的", "OK", "Cancel");
//                        })
//                        .onForwardToSettings((scope, deniedList) -> {
//                            scope.showForwardToSettingsDialog(deniedList, "你需要设置这个权限,", "OK", "Cancel");
//                        })
//                        .request(new RequestCallback() {
//                            @Override
//                            public void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList) {
//                                if (allGranted) {
//                                    Toast.makeText(MainActivity.this, "所有权限申请成功" + grantedList, Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(MainActivity.this, "这个权限被拒绝: " + deniedList, Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                break;
        }
    }
