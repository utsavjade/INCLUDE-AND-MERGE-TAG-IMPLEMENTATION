package com.example.utsav.includeandmergetag;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
private View layout1,layout2,layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_tag_layout);
        ((EditText)findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
        ((EditText)findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
        Toast.makeText(this,"on include_tag_layout",Toast.LENGTH_LONG).show();
    }
public void click(View view){
    Toast.makeText(this,"switched to merge_tag_layout",Toast.LENGTH_LONG).show();
    setContentView(R.layout.merge_tag_layout);
    ((EditText)findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
    ((EditText)findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");

}
    public void click2(View view){
        Toast.makeText(this,"switched to include_tag_layout",Toast.LENGTH_LONG).show();
        setContentView(R.layout.include_tag_layout);
        ((EditText)findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
        ((EditText)findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");

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
