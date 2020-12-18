package com.example.hilt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyView extends LinearLayout {
    private int colorText;
    private String textLeft;
    private String textTitle;
    private String textRight;
    private TextView tvLeft;
    private TextView tvTitle;
    private TextView tvRight;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //从xml的属性中获取到字体颜色与string
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.MyTitle);
        colorText=ta.getColor(R.styleable.MyTitle_textColor, Color.BLACK);
        textLeft=ta.getString(R.styleable.MyTitle_leftText);
        textTitle=ta.getString(R.styleable.MyTitle_titleText);
        textRight=ta.getString(R.styleable.MyTitle_rightText);
        ta.recycle();

        //获取到控件
        //加载布局文件，与setContentView()效果一样
        LayoutInflater.from(context).inflate(R.layout.my_view, this);
        tvLeft=(TextView)findViewById(R.id.tv_left);
        tvTitle=(TextView)findViewById(R.id.tv_title);
        tvRight=(TextView)findViewById(R.id.tv_right);

        //将控件与设置的xml属性关联
        tvLeft.setTextColor(colorText);
        tvLeft.setText(textLeft);
        tvTitle.setTextColor(colorText);
        tvTitle.setText(textTitle);
        tvRight.setTextColor(colorText);
        tvRight.setText(textRight);
    }
}
