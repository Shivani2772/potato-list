package com.potatolist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

class PotatoAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Potato> potatoInfo = new ArrayList<Potato>();

    public PotatoAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return potatoInfo.size();
    }
    public void setPotatoInfo(ArrayList<Potato> c){
        this.potatoInfo = c;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(potatoInfo.get(position).getIcon());
        return imageView;
    }

}
