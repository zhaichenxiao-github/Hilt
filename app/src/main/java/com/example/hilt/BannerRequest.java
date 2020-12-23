package com.example.hilt;

import com.example.httplibrary.callback.BaseCallBack;
import com.example.httplibrary.client.HttpObserable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.orhanobut.logger.Logger;

public abstract class BannerRequest<T> extends BaseCallBack<T> {
    Response response;
    @Override
    protected T onConvert(String result) {
        T t=null;
        response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        String errorMsg = response.getErrorMsg();
        int errorCode = response.getErrorCode();
        Logger.d(errorMsg);
        switch (errorCode){
            case 0:
                if (isCodeSuccess()){
                    t=convert(data);
                }
                break;
        }
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        if (response!=null){
            return response.getErrorCode()==0;
        }
        return false;
    }

}
