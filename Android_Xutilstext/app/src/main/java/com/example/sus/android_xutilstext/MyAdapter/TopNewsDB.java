package com.example.sus.android_xutilstext.MyAdapter;

import android.util.Log;

import com.example.sus.android_xutilstext.Bean.TopNews;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.List;

import static org.xutils.x.getDb;

/**
 * Date：2017/4/11
 * author: 曹政杰Administrator.
 * function：
 */

public class TopNewsDB {
    private static DbManager db;
    DbManager.DaoConfig daoConfig = DatabaseOpenHelper.getDaoConfig();
    public TopNewsDB(){
       // db = DatabaseOpenHelper.getInstance();
        db = getDb(daoConfig);
    }

    //db = x.getDb(daoConfig);
    public void savePerson(TopNews top){
        try {
            db.save(top);
            Log.d("xyz","save succeed!");
        } catch (DbException e) {
            Log.d("xyz",e.toString());
        }
    }

    public static List<TopNews> loadPerson(){
        List<TopNews> list = null;
        try {
            list = db.selector(TopNews.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

}
