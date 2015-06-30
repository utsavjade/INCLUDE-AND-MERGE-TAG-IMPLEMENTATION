package com.example.utsav.includeandmergetag;

import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class ImageDownloadActivity extends ActionBarActivity {
    private ArrayList<URL> mImageUrlList;
    private ImageDownloadTask mImageDownloadTask;
    public int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("in create");
        setContentView(R.layout.activity_image_download);
        mImageUrlList = new ArrayList<URL>();
        try {
           mImageUrlList.add(new URL("http://www.danmulhern.com/wp-content/uploads/2013/03/url-128x128.jpg"));
            mImageUrlList.add(new URL("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg"));
            mImageUrlList.add(new URL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR7qOga3T5MiiOzUMdOnB29l9_Qa1mNJBZhSLnwcjG8ZrmlFd5Y"));
            mImageUrlList.add(new URL("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQMMhbCZYAmxo8eeJFr6bs7RG5e--1tM0xknEu8sWSpr4mPo6KQ"));
            mImageUrlList.add(new URL("https://upload.wikimedia.org/wikipedia/commons/5/5b/Ultraviolet_image_of_the_Cygnus_Loop_Nebula_crop.jpg"));
            mImageUrlList.add(new URL("http://cdn.phys.org/newman/gfx/news/hires/2013/spitzerandal.jpg"));
            mImageUrlList.add(new URL("http://www.danmulhern.com/wp-content/uploads/2013/03/url-128x128.jpg"));
            mImageUrlList.add(new URL("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg"));
            mImageUrlList.add(new URL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR7qOga3T5MiiOzUMdOnB29l9_Qa1mNJBZhSLnwcjG8ZrmlFd5Y"));
            mImageUrlList.add(new URL("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQMMhbCZYAmxo8eeJFr6bs7RG5e--1tM0xknEu8sWSpr4mPo6KQ"));
            mImageUrlList.add(new URL("https://upload.wikimedia.org/wikipedia/commons/5/5b/Ultraviolet_image_of_the_Cygnus_Loop_Nebula_crop.jpg"));
            mImageUrlList.add(new URL("http://cdn.phys.org/newman/gfx/news/hires/2013/spitzerandal.jpg"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Logger.d("CRAP");
        }
        mImageDownloadTask = new ImageDownloadTask(this);
        if (savedInstanceState != null) {
            int i = savedInstanceState.getInt("PROGRESS", 0);
            ArrayList<URL> list=new ArrayList<>();
            for (int j=i;j<mImageUrlList.size();j++)
                list.add(mImageUrlList.get(j));
          Logger.d(""+list.size());
            mImageDownloadTask.execute(list.toArray(new URL[list.size()]));
        }
        else
            mImageDownloadTask.execute(mImageUrlList.toArray(new URL[mImageUrlList.size()]));
        Logger.d("len+++" + mImageUrlList.size());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        mImageDownloadTask.cancel(true);
        while(!mImageDownloadTask.isCancelled());
            outState.putInt("PROGRESS", progress);

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_download, menu);
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
