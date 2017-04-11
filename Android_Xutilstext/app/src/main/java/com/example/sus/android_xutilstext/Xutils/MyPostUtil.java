package com.example.sus.android_xutilstext.Xutils;

import android.util.Log;

import com.example.sus.android_xutilstext.Bean.Titles;
import com.example.sus.android_xutilstext.Bean.TopNews;
import com.example.sus.android_xutilstext.MyAdapter.TopNewsDB;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Date：2017/4/11
 * author: 曹政杰Administrator.
 * function：
 */

public class MyPostUtil {
    private String url="http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news";
      public void Post( final Biaoti bt){
          RequestParams params=new RequestParams(url);
          params.addHeader("head","android");
          x.http().post(params, new Callback.CommonCallback<String>() {
              @Override
              public void onSuccess(String result) {
             Gson gson=new Gson();
             Titles title     =gson.fromJson(result, Titles.class);
                  List<Titles.ResultBean.DateBean> data=title.getResult().getDate();
                  TopNewsDB tdb=new TopNewsDB();
                  for (int i=0;i<data.size();i++){
                      TopNews tp=new TopNews();
                      tp.setUri(data.get(i).getUri());
                      tp.setTitle(data.get(i).getTitle());
                      tdb.savePerson(tp);
                  }

                  Log.i("tag",result.toString());
             bt.onSuccess(result);

              }

              @Override
              public void onError(Throwable ex, boolean isOnCallback) {

              }

              @Override
              public void onCancelled(CancelledException cex) {

              }

              @Override
              public void onFinished() {

              }
          });
}
    public interface Biaoti{
        void onSuccess(String result);

    }


}
