package com.example.utsav.includeandmergetag.CounterTaskViaFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.includeandmergetag.Logger;
import com.example.utsav.includeandmergetag.R;

public class IFragment extends Fragment {
    View mContentView;
    ITask mTask;
    ITask.Holder mHolder = new ITask.Holder();

    public IFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Logger.d("in create view");
        mContentView = inflater.inflate(R.layout.fragment_i, container, false);
        if (savedInstanceState != null) {
            Logger.d("saved Instance!=null");
            mHolder = (ITask.Holder) savedInstanceState.getSerializable(ITask.Holder.HOLDER_KEY);
            mHolder=mHolder==null?new ITask.Holder():mHolder;
        }
        return mContentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTask = new ITask(mHolder, mContentView);
        mTask.execute();
    }

    @Override
    public void onStop() {
        mTask.cancel(true);
        super.onStop();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

            outState.putSerializable(ITask.Holder.HOLDER_KEY, mHolder);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
