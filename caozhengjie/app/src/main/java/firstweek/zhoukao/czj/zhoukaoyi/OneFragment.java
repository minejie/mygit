﻿package firstweek.zhoukao.czj.zhoukaoyi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import firstweek.zhoukao.czj.zhoukaoyi.adapter.mybaseadapters;
import firstweek.zhoukao.czj.zhoukaoyi.bean.User;
import firstweek.zhoukao.czj.zhoukaoyi.xutil.MyXutil;



public class OneFragment extends Fragment {
    private String uri;
    private ListView lists;

    public OneFragment(String uri) {
        this.uri = uri;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.f1,container,false);
        lists = (ListView) v.findViewById(R.id.lists);
        MyXutil myXutil=new MyXutil(uri);
        myXutil.initutils();
         myXutil.huidiao(new MyXutil.Addinter() {
             @Override
             public void getaddinter(String result) {
                 Log.d("tag","-------------"+result);
                 Gson gson=new Gson();
                 User user = gson.fromJson(result, User.class);
                 List<User.ResultBean.DataBean> data =user.getResult().getData();

                 mybaseadapters ada=new mybaseadapters(data,getActivity());
                lists.setAdapter(ada);
             }
         });
        return v;

    }
}
