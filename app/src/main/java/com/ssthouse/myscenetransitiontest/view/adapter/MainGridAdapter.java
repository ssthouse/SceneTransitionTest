package com.ssthouse.myscenetransitiontest.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ssthouse.myscenetransitiontest.R;
import com.ssthouse.myscenetransitiontest.model.Item;

/**
 * 主界面的Adapter
 * Created by ssthouse on 2015/8/27.
 */
public class MainGridAdapter extends BaseAdapter {

    private Context context;

    public MainGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Item.ITEMS.length;
    }

    @Override
    public Object getItem(int position) {
        return Item.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return ((Item)getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.grid_item, null);
            viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.id_iv),
                    (TextView) convertView.findViewById(R.id.id_tv));
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //填充数据
        Item item = (Item) getItem(position);
        Picasso.with(context).load(item.getThumbnailUrl()).into(viewHolder.ic);
        viewHolder.tv.setText(item.getName());
        return convertView;
    }

    class ViewHolder {
        ImageView ic;
        TextView tv;

        public ViewHolder(ImageView ic, TextView tv) {
            this.ic = ic;
            this.tv = tv;
        }
    }
}
