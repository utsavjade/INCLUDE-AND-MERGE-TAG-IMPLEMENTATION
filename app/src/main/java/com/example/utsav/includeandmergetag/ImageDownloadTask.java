package com.example.utsav.includeandmergetag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import java.io.BufferedReader;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * Created by utsav on 30/6/15.
 */
public class ImageDownloadTask extends AsyncTask<URL, Integer, Void> {
    private ArrayList<URL> mImageUrl;
    ImageDownloadActivity mActivity;
    boolean isCancelled=false;
    int i;
    public ImageDownloadTask(ImageDownloadActivity activity) {
        this.mActivity = activity;
    }

    @Override
    protected Void doInBackground(URL... params) {
        Logger.d("in back"+params.length);

        for (i = 0; i < params.length && !isCancelled ; i++) {
            try {
                Logger.d(">>"+params[i]);
                HttpURLConnection connection = (HttpURLConnection) params[i].openConnection();
                connection.connect();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                publishProgress(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onCancelled() {
        isCancelled=true;
        mActivity.progress=i;
        Logger.d(">>>CANCLED AT "+i);
     //   super.onCancelled();
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if(mActivity!=null){
            ((SeekBar)mActivity.findViewById(R.id.progressBar)).setProgress(values[0]);

        }
    }
}
