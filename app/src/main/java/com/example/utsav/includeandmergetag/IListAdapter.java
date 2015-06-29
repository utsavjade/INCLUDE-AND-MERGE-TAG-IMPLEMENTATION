package com.example.utsav.includeandmergetag;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by utsav on 29/6/15.
 */
public class IListAdapter extends BaseAdapter {
    public class ItemHolder {
        Button button;
        EditText editText1, editText2, editText3;
        TextView tv;
    }

    private ArrayList<String[]> contactsArray;
    private boolean isGrid;
    private Activity activity;

    public IListAdapter(ArrayList<String[]> contactsArray, boolean isGrid, Activity activity) {
        this.contactsArray = contactsArray;
        this.isGrid = isGrid;
        this.activity = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ItemHolder holder;
        if (isGrid) {
            if (convertView == null) {
                holder = new ItemHolder();
                convertView = activity.getLayoutInflater().inflate(R.layout.grid_box, null);
                holder.tv = ((TextView) convertView.findViewById(R.id.tv));
                holder.button = (Button) convertView.findViewById(R.id.button);
                convertView.setTag(holder);
            } else
                holder = (ItemHolder) convertView.getTag();
            holder.tv.setText(contactsArray.get(position)[0]);
            holder.button.setClickable(false);

        } else {

            if (convertView == null) {
                holder = new ItemHolder();
                convertView = activity.getLayoutInflater().inflate(R.layout.box, null);
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
            holder.editText1.setFocusable(false);
            holder.editText2.setFocusable(false);
            holder.editText3.setFocusable(false);

        }
        holder.button.setFocusable(false);
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
