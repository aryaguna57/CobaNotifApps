package com.cobacoba.cobacoba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MViewHolder> {
    private ArrayList<ItemRecyclerView> mItemList;

    public static class MViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView1;
        public ImageView mImageView2;
        public ImageView mImageView3;
        public ImageView mImageView4;
        public TextView mTextView1;
        public TextView mTextView2;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView1 = itemView.findViewById(R.id.status_red);
            mImageView2 = itemView.findViewById(R.id.status_green);
            mImageView3 = itemView.findViewById(R.id.ic_subtitle);
            mImageView4 = itemView.findViewById(R.id.ic_delete);
            mTextView1 = itemView.findViewById(R.id.tvTitle);
            mTextView2 = itemView.findViewById(R.id.tvSubtitle);
        }
    }

    public MyAdapter(ArrayList<ItemRecyclerView> itemList){
        mItemList = itemList;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item,parent,false);
        MViewHolder mvh = new MViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder( MViewHolder holder, int position) {
        final ItemRecyclerView currentItem = mItemList.get(position);
        holder.mImageView1.setImageResource(currentItem.getImageResource1());
        holder.mImageView2.setImageResource(currentItem.getImageResource2());
        holder.mImageView3.setImageResource(currentItem.getImageResource3());
        holder.mImageView4.setImageResource(currentItem.getImageResource4());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

        holder.mImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    public void remove(ItemRecyclerView item){
        int position = mItemList.indexOf(item);
        mItemList.remove(position);
        notifyItemRemoved(position);
    }
}
