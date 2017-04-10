package firstweek.zhoukao.czj.zhoukaoyi.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;


public class myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
       
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,640).build();


        ImageLoader.getInstance().init(configuration);
    }
}
