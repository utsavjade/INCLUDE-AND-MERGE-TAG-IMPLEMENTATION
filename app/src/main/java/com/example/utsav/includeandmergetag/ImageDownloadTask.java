package com.example.utsav.includeandmergetag;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * Created by utsav on 30/6/15.
 */
public class ImageDownloadTask extends AsyncTask<URL, Integer, Void> {
    //private ArrayList<URL> mImageUrl;
    ProgressHolder mHolder;
    private int mLength;
    private Activity mActivity;
    //private Bitmap mBitmap;

    public ImageDownloadTask(ProgressHolder holder, Activity activity) {
        this.mHolder = holder == null ? new ProgressHolder() : holder;
        this.mActivity = activity;
    }

    public static class ProgressHolder {
        public int progress = 0;
        public ArrayList<Bitmap> bitmaps = new ArrayList<>();
    }

    @Override
    protected Void doInBackground(URL... params) {
        Logger.d("in back"+params.length);
        mLength = params.length;
        for (int i = mHolder.progress; i < mLength && !super.isCancelled(); i = (i + 1) % mLength) {
           //Logger.d("iteration "+i);
            try {
                HttpURLConnection connection = (HttpURLConnection) params[i].openConnection();
                connection.connect();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                synchronized (mHolder.bitmaps) {
                    mHolder.bitmaps.add(BitmapFactory.decodeStream(connection.getInputStream()));
                }
                publishProgress(new Integer[]{i});
            } catch (IOException e) {
                e.printStackTrace();
                Logger.d("CRAPPER"+i);
            }
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        Logger.d("progress canceled at " + mHolder.progress);
        super.onCancelled();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Logger.d("in progress");
        mHolder.progress = values[0];
        if (mActivity != null) {
            ((SeekBar) mActivity.findViewById(R.id.progressBar)).setProgress((values[0] / mLength) * 100);
            ((ImageView) mActivity.findViewById(R.id.imageView)).setImageBitmap(mHolder.bitmaps.get(values[0]));
        }
    }
}
