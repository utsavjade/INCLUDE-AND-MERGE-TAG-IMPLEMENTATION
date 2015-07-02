package com.example.utsav.includeandmergetag.CounterTaskViaFragment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.utsav.includeandmergetag.Logger;
import com.example.utsav.includeandmergetag.R;


public class FragmentAndTaskActivity extends ActionBarActivity {
    private IFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("in ACTIVITY CREATE");
        setContentView(R.layout.activity_fragment_and_task);
        mFragment=new IFragment();
        mFragment.setRetainInstance(true);
        if(savedInstanceState==null)
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentLayout,mFragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_and_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
