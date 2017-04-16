package application.cartoon.com.homework.frag;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import application.cartoon.com.homework.R;
import application.cartoon.com.homework.adapter.MyBaseAdapter;
import application.cartoon.com.homework.bean.CategoryBean;
import application.cartoon.com.homework.utils.HttpUtils;
import application.cartoon.com.homework.utils.Url;

/**
 * A simple {@link Fragment} subclass.
 */
public class Left extends Fragment {


    private ListView lv;
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String json= (String) msg.obj;
        CategoryBean categoryBean = new Gson().fromJson(json, CategoryBean.class);
        data = categoryBean.getData();
        lv.setAdapter(new MyBaseAdapter(data,getActivity()));
    }
};
    private List<CategoryBean.DataBean> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.frag, container, false);
        lv = (ListView) inflate.findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onLeftItemClick.itemClick(data.get(position).getName(),position);
            }
        });
        new HttpUtils(handler, Url.TITLEURL).start();
        return inflate;
    }
    private OnLeftItemClick onLeftItemClick;
    public void setOnLeftItemClick(OnLeftItemClick onLeftItemClick){
        this.onLeftItemClick=onLeftItemClick;
    }
public interface  OnLeftItemClick{
    void  itemClick(String title,int positon);
}
}
