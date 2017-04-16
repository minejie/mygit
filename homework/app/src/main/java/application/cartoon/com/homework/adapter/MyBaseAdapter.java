package application.cartoon.com.homework.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import application.cartoon.com.homework.R;
import application.cartoon.com.homework.bean.CategoryBean;
import application.cartoon.com.homework.bean.ContentBean;


public class MyBaseAdapter extends BaseAdapter {
    private List list;

    public MyBaseAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object o = list.get(position);
        ViewHolder1 holder1=null;
        ViewHolder2 holder2=null;
        CategoryBean.DataBean bean1=null;
        ContentBean.DataBean bean2=null;
      if( o instanceof CategoryBean.DataBean)
      {
           bean1=(CategoryBean.DataBean)o;
      }
      if (o instanceof ContentBean.DataBean){
          bean2=(ContentBean.DataBean)o;
      }
        if (convertView==null){
if (bean1==null){
    holder2=new ViewHolder2();
    convertView=View.inflate(context, R.layout.list_item,null);
    holder2.title= (TextView) convertView.findViewById(R.id.title);
    holder2.what= (TextView) convertView.findViewById(R.id.forsom);
    holder2.price= (TextView) convertView.findViewById(R.id.price);
    convertView.setTag(holder2);
}else{
    holder1=new ViewHolder1();
    convertView=View.inflate(context, android.R.layout.simple_list_item_1,null);
    holder1.title= (TextView) convertView.findViewById(android.R.id.text1);

    convertView.setTag(holder1);
}
  }else {
if (bean1==null){
    holder2= (ViewHolder2) convertView.getTag();
}else {
    holder1=(ViewHolder1) convertView.getTag();
}
        }
if (bean1==null){
    holder2.title.setText(bean2.getTitle());
    holder2.what.setText(bean2.getApply());
    holder2.price.setText(bean2.getBuy_price()+"元");
}else {
    holder1.title.setText(bean1.getName());
}


        return convertView;
    }
    class ViewHolder2{
        TextView title,what,price;

    }
    class ViewHolder1{
        TextView title;

    }

}
