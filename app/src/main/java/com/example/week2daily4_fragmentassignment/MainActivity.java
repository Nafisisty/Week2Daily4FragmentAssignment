package com.example.week2daily4_fragmentassignment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInputFragment.OnFragmentInteractionListener {

    UserInputFragment userInputFragment;
    UserListFragment userListFragment;
    static ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputFragment = new UserInputFragment();
        userListFragment = new UserListFragment();

        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.userInputFragmentId, userInputFragment)
                .commit();
        fm.beginTransaction()
                .replace(R.id.userListFragmentId, userListFragment)
                .commit();

    }


    @Override
    public void sendToActivity(User user) {

        userListFragment.setDisplay(user);

    }
}
