package com.adsun.testobserver.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adsun.testobserver.R;
import com.adsun.testobserver.model.User;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    List<User> userList = new ArrayList<>();

    UserClickListener mUserClickListener;

    public CustomAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void setItemUserClickListener (UserClickListener listener) {
        this.mUserClickListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(userList.get(position).getTitle());
        holder.tvId.setText(userList.get(position).getId());
        holder.tvBody.setText(userList.get(position).getBody());

        holder.setItemClickListener(new ItemUserClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                mUserClickListener.onUserClick(userList.get(position), position, isLongClick);

            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView tvId, tvTitle, tvBody;
        ItemUserClickListener itemListener;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.user_id);
            tvTitle = (TextView) itemView.findViewById(R.id.user_title);
            tvBody = (TextView) itemView.findViewById(R.id.user_body);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemUserClickListener itemClickListener) {
            this.itemListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemListener.onClick(view,getAdapterPosition(),false); // Gọi interface , false là vì đây là onClick

        }

        @Override
        public boolean onLongClick(View view) {
            itemListener.onClick(view,getAdapterPosition(),true); // Gọi interface , true là vì đây là onLongClick
            return true;
        }
    }

    public interface ItemUserClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    public interface UserClickListener {
        void onUserClick(User user, int position, boolean isLongClick);
    }
}
