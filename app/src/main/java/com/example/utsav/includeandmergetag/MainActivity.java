package com.example.utsav.includeandmergetag;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private View layout1, layout2, layout3;
    private int flag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(this,ImageDownloadActivity.class);
        startActivity(intent);
        //clickToSwitchLayout(null);
/*
        setContentView(R.layout.include_tag_layout);
        ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
        ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
        Toast.makeText(this, "on include_tag_layout", Toast.LENGTH_LONG).show();
*/
    }

    public void clickToSwitchLayout(View view) {

        switch (flag) {
            case 0:
                setContentView(R.layout.activity_main);
                ArrayList<String[]> arrayList = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    arrayList.add(new String[]{"utsav" + i, "utsav" + i + "@mail", "utsav" + i + "@jade"});
                }
                IListAdapter adapter = new IListAdapter(arrayList,false,this);
                ListView listView = (ListView) findViewById(R.id.list_item);
                listView.setAdapter(adapter);
                //listView.se
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(), "item id:" + position, Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "click");
                    }
                });
                flag = 1;
                break;
            case 1:
                Toast.makeText(this, "switched to merge_tag_layout", Toast.LENGTH_LONG).show();
                setContentView(R.layout.merge_tag_layout);
                ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
                ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
                flag = 2;
                break;
            case 2:
                setContentView(R.layout.include_tag_layout);
                ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
                ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
                flag = 3;
                break;
            case 3:
                setContentView(R.layout.grid_layout);
                ArrayList<String[]> arrayList1 = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    arrayList1.add(new String[]{"utsav" + i, "utsav" + i + "@mail", "utsav" + i + "@jade"});
                }
                IListAdapter adapter1 = new IListAdapter(arrayList1,true,this);
                GridView gridView = (GridView) findViewById(R.id.gridview);
                gridView.setAdapter(adapter1);
                //listView.se
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(), "item id:" + position, Toast.LENGTH_SHORT).show();
                        clickToSwitchLayout(view);
                        Log.d("TAG", "click");
                    }
                });
                flag = 4;
                break;
            case 4:
                setContentView(R.layout.style_layout);
                flag=5;
                break;
            case 5:
                setContentView(R.layout.style_layout2);
                flag=0;
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
