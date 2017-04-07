package com.example.dell.firstweek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * date: 2017/4/7
 * author: 曹政杰
 * function: 适配器
 */

public class MyAdapter extends BaseAdapter {

    public MyAdapter(Context context, List<Bean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<Bean.ListBean> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView==null){
            v = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            v.t1 = (TextView) convertView.findViewById(R.id.t1);
            v.t2 = (TextView) convertView.findViewById(R.id.t2);
            convertView.setTag(v);
        }else {
            v = (ViewHolder) convertView.getTag();
        }
        v.t2.setText(list.get(position).getAddress());
        v.t1.setText(list.get(position).getSite_name());
        return convertView;
    }
    class ViewHolder{
        private TextView t1,t2,t3,t4;
        private ImageView img;
    }
}
