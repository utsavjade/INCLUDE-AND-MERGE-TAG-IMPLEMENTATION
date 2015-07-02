package com.example.utsav.includeandmergetag.TwoButtonTwoFragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.includeandmergetag.Logger;
import com.example.utsav.includeandmergetag.R;

import java.util.ArrayList;

public class TwoButtonActivity extends ActionBarActivity {
    private IFragment mFragment;
    private ArrayList<FragmentTransaction> mFragmentTransactions = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ViewGroup mFragmentHolder;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_button);
        mFragmentHolder = (ViewGroup) findViewById(R.id.fragmentHolder);
        mFragmentManager = getSupportFragmentManager();
    }

    public void onClickToSwitch(View view) {
        switch (view.getId()) {
            case R.id.button1:
                addFragment("HI");
                break;
            case R.id.button2:
                addFragment("BYE");
                break;
        }
    }

    private void addFragment(String text) {
        Logger.d("1");
        int i = 0;
        ArrayList<Fragment> fragments = new ArrayList<>();
        if (mFragmentManager.getBackStackEntryCount() > 0) {
            for (i = 0; i < mFragmentManager.getBackStackEntryCount()
                    && (!mFragmentManager.getBackStackEntryAt(i).getName().equals(text)); i++) {
                fragments.add(mFragmentManager.findFragmentByTag(mFragmentManager.getBackStackEntryAt(i).getName()));
            }
            mFragmentManager.popBackStack(text, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            for (Fragment fragment : fragments)
                mFragmentManager.beginTransaction().add(fragment, fragment.getTag()).addToBackStack(fragment.getTag());
        }
        mFragment = new IFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IFragment.ARG_KEY, text);
        mFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentHolder, mFragment, text).addToBackStack(text).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_button, menu);
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
