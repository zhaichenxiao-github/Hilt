package com.example.hilt;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class NetMoudle {

    @Provides
    static ArrayList<String> list(){
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("哈哈哈"+i);
        }
        return strings;
    }
    @Provides
    static MyBodyAdapter myBodyAdapter(ArrayList<String> list){
        return new MyBodyAdapter(list);
    }
    @Provides
    static  MyTitleAdapter myTitleAdapter(ArrayList<String> list){
        return new MyTitleAdapter(list);
    }
}
