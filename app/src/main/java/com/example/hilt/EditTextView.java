package com.example.hilt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EditTextView extends RelativeLayout {

    private TextView tvName;
    private EditText edName;
    public OnClickListener onClickListener;
    public OnLongClickListener onLongClickListener;

    @Override
    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public EditTextView(Context context) {
        this(context,null);
    }

    public EditTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.item_edxit,this);
        initView();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EditTextView, defStyleAttr, 0);
        int count = array.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr=array.getIndex(i);
            if (attr == R.styleable.EditTextView_TextName){
                tvName.setText(array.getString(attr));
            } else if (attr == R.styleable.EditTextView_TextColor){
                tvName.setTextColor(array.getColor(attr, Color.WHITE));
            } else if (attr == R.styleable.EditTextView_TextSize){
                tvName.setTextSize(TypedValue.COMPLEX_UNIT_PX, array.getDimensionPixelSize(attr, 0));
            } else if (attr == R.styleable.EditTextView_TextNameVisibility){
                int visible = array.getInt(attr, View.VISIBLE);
                setVisibility(tvName, visible);
            } else if (attr == R.styleable.EditTextView_editTextName){
                edName.setText(array.getString(attr));
            } else if (attr == R.styleable.EditTextView_editTextColor){
                edName.setTextColor(array.getColor(attr, Color.WHITE));
            }else if (attr == R.styleable.EditTextView_editTextSize){
                edName.setTextSize(TypedValue.COMPLEX_UNIT_PX, array.getDimensionPixelSize(attr, 0));
            } else if (attr == R.styleable.EditTextView_editTextNameVisibility){
                int anInt = array.getInt(attr, View.VISIBLE);
                setVisibility(edName,anInt);
            }
        }
        array.recycle();
        tvName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClick(v);
                }
            }
        });
        edName.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onLongClickListener!=null){
                    onLongClickListener.onLongClick(v);
                }
                return false;
            }
        });
    }

    private void setVisibility(View view, int visible) {
        view.setVisibility(visible);
    }

    private void initView() {
        tvName = findViewById(R.id.tv_name);
        edName = findViewById(R.id.ed_name);
    }

    //设置标题
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvName.setText(title);
        }
    }
    //设置左标题
    public void setLeftText(String title) {
        if (!TextUtils.isEmpty(title)) {
            edName.setText(title);
        }
    }
    //设置标题大小
    public void setTitleSize(int size) {
        if (tvName != null) {
            tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }
    //设置右图标显示隐藏
    public void setTextNameVisibility(int visibility) {
        if (tvName != null) {
            tvName.setVisibility(visibility);
        }
    }

    public interface OnCLickListener{
        void onClick(View view);
        void onLongClick(View view);
    }
}
