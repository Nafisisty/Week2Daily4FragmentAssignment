package com.example.week2daily4_fragmentassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<User> userArrayList;

    public RecyclerViewAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        User user = userArrayList.get(position);

        if(user != null) {
            viewHolder.setItemUser(user);

            viewHolder.userNameTextView.setText(user.getUserName());
            viewHolder.userEmailTextView.setText(user.getUserEmail());
        }
    }

    @Override
    public int getItemCount() {
        return userArrayList != null ? userArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userNameTextView, userEmailTextView;
        User itemUser;

        public void setItemUser(User itemUser) {
            this.itemUser = itemUser;
        }

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            userNameTextView = itemView.findViewById(R.id.userNameTextViewId);
            userEmailTextView = itemView.findViewById(R.id.userEmailTextViewId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CalculateAsyncTask calculateAsyncTask = new CalculateAsyncTask(itemUser.getUserName());
                    calculateAsyncTask.execute();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int length = calculateAsyncTask.nameLength;
                    Toast.makeText(view.getContext(), "Name Length is " + length, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void addUser(User user) {

        if(userArrayList == null){

            userArrayList = new ArrayList<>();

        }

        userArrayList.add(user);
        notifyDataSetChanged();

    }
}
