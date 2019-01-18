package com.example.week2daily4_fragmentassignment;

import android.os.AsyncTask;
import android.widget.Toast;

public class CalculateAsyncTask extends AsyncTask<String, Integer, Integer> {

    String userName;
    int nameLength;

    public CalculateAsyncTask(String userName) {
        this.userName = userName;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Integer doInBackground(String... strings) {

        nameLength = userName.length();
        publishProgress(nameLength);
        return nameLength;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        nameLength = integer;
    }
}
