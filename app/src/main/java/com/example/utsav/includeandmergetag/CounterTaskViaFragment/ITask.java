package com.example.utsav.includeandmergetag.CounterTaskViaFragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.utsav.includeandmergetag.Logger;
import com.example.utsav.includeandmergetag.R;

import java.io.Serializable;

/**
 * Created by utsav on 1/7/15.
 */
public class ITask extends AsyncTask<Void,Integer,Void> {
    Holder mHolder;
    View mContentView;
    TextView mTextView;
    public static class Holder implements Serializable{
        public static final String HOLDER_KEY="HOLDER";
        public int progress=0;
    }
    public ITask(Holder holder,View contentView){
        this.mHolder=holder==null?new Holder():holder;
        this.mContentView=contentView;
        mTextView= (TextView) mContentView.findViewById(R.id.textView);
        Logger.d("in itask contruc");
    }
    @Override
    protected Void doInBackground(Void... params) {
        Logger.d("in BACKGROUND "+mHolder.progress);
        int i=mHolder.progress;
        while(!isCancelled()){
            i++;
            publishProgress(i);
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        Logger.d("ONCANCELLEd");
        super.onCancelled();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Logger.d("in PROGRESS UPDATE "+values[0]);
        mHolder.progress=values[0];
        mTextView.setText("" + values[0]);

    }
}
