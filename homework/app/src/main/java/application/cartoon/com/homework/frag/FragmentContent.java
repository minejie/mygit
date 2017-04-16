package application.cartoon.com.imhappy.frag;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import application.cartoon.com.homework.R;
import application.cartoon.com.homework.adapter.MyBaseAdapter;
import application.cartoon.com.homework.bean.ContentBean;
import application.cartoon.com.homework.utils.HttpUtils;



public class FragmentContent extends Fragment {

    private ListView lv;
    public String url;
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        String json= (String) msg.obj;

        lv.setAdapter(new MyBaseAdapter(new Gson().fromJson(json, ContentBean.class).getData(),getActivity()));
    }
};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content, container, false);
        lv = (ListView)view.findViewById(R.id.lv);
        new HttpUtils(handler,url).start();
        return view;
    }
}
