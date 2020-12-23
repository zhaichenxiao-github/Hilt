package com.example.hilt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MyBodyAdapter extends RecyclerView.Adapter<MyBodyAdapter.ViewHolder> {
    private ArrayList<String> list;

    private onClickListener onClickListener;

    public MyBodyAdapter.onClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(MyBodyAdapter.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public  MyBodyAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                Toast.makeText(parent.getContext(),"吐司了"+absoluteAdapterPosition,Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position));
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
    public interface onClickListener{
        void onClick(View v,int position);
    }
}
