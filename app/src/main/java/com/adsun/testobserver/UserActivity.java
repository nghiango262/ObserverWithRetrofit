package com.adsun.testobserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.adsun.testobserver.adapter.CustomAdapter;
import com.adsun.testobserver.contract.UserContract;
import com.adsun.testobserver.model.User;
import com.adsun.testobserver.presenter.UserPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class UserActivity extends AppCompatActivity implements UserContract.View, View.OnClickListener, CustomAdapter.UserClickListener {

    private FloatingActionButton btAddUser;
    private RecyclerView recyclerview;
    //
    private UserPresenter mPresenter;

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        mPresenter = new UserPresenter(this);
        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerview = findViewById(R.id.recyclerview);
        btAddUser = findViewById(R.id.bt_add_user);
        btAddUser.setOnClickListener(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);

        mPresenter.loadUsers();

    }

    @Override
    public void loadDataInList(List<User> users) {
        adapter = new CustomAdapter(users);
        adapter.setItemUserClickListener(this);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (view != null) {
            // Get view component id.
            int id = view.getId();
            if (id == R.id.bt_add_user) {
                mPresenter.addUser(new User("vupham", "123456", "Vu BD", "Pham"));
            }
        }
    }

    @Override
    public void onUserClick(User user, int position, boolean isLongClick) {
        Toast.makeText(this,user.toString(), Toast.LENGTH_LONG).show();
    }
}
