package com.example.utsav.includeandmergetag;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private View layout1, layout2, layout3;
    private int flag;
    private class IListAdapter extends BaseAdapter {
        public class ItemHolder {
            Button button;
            EditText editText1,editText2,editText3;
        }

        private ArrayList<String[]> contactsArray;

        public IListAdapter(ArrayList<String[]> contactsArray) {
            this.contactsArray = contactsArray;
        }

        @Override
        public int getCount() {
            return contactsArray.size();
        }

        @Override
        public Object getItem(int position) {
            return contactsArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemHolder holder;
            if (convertView == null) {
                holder = new ItemHolder();
                convertView = getLayoutInflater().inflate(R.layout.box, null);
                holder.button = (Button) convertView.findViewById(R.id.button1);
                holder.button.setText("SWITCH LAYOUT");
                holder.editText1 = (EditText) convertView.findViewById(R.id.editText1);
                holder.editText2 = (EditText) convertView.findViewById(R.id.editText2);
                holder.editText3 = (EditText) convertView.findViewById(R.id.editText3);

                convertView.setTag(holder);
            } else
                holder = (ItemHolder) convertView.getTag();
            holder.editText1.setText(contactsArray.get(position)[0]);
            holder.editText2.setText(contactsArray.get(position)[1]);
            holder.editText3.setText(contactsArray.get(position)[2]);
            switch (position % 3) {
                case 0:
                    holder.button.setBackgroundResource(R.drawable.img1);
                    break;
                case 1:
                    holder.button.setBackgroundResource(R.drawable.img2);
                    break;
                case 2:
                    holder.button.setBackgroundResource(R.drawable.img3);

            }
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        click(null);
/*
        setContentView(R.layout.include_tag_layout);
        ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
        ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
        Toast.makeText(this, "on include_tag_layout", Toast.LENGTH_LONG).show();
*/
    }

    public void click(View view) {
        switch(flag){
            case 0:
                setContentView(R.layout.activity_main);
                ArrayList<String[]> arrayList=new ArrayList<>();
                for(int i=0;i<20;i++){
                    arrayList.add(new String[]{"utsav"+i,"utsav"+i+"@mail","utsav"+i+"@jade"});
                }
                IListAdapter adapter=new IListAdapter(arrayList);
                ListView listView= (ListView) findViewById(R.id.list_item);
                listView.setAdapter(adapter);
                flag=1;
                break;
            case 1:
                Toast.makeText(this, "switched to merge_tag_layout", Toast.LENGTH_LONG).show();
                setContentView(R.layout.merge_tag_layout);
                ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
                ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
                flag=2;
                break;
            case 2:
                setContentView(R.layout.include_tag_layout);
                ((EditText) findViewById(R.id.layout2).findViewById(R.id.editText1)).setText("abcd\nefgh\nijklm");
                ((EditText) findViewById(R.id.layout3).findViewById(R.id.editText2)).setText("nopq\nqrstu\nwxyz");
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
