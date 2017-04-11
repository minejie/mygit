package com.example.sus.android_xutilstext;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.sus.android_xutilstext.Bean.Titles;
import com.example.sus.android_xutilstext.Bean.TopNews;
import com.example.sus.android_xutilstext.Fragment.Fragment1;
import com.example.sus.android_xutilstext.MyAdapter.MypagerAdapter;
import com.example.sus.android_xutilstext.MyAdapter.TopNewsDB;
import com.example.sus.android_xutilstext.Urlutlis.MyUrl;
import com.example.sus.android_xutilstext.Xutils.MyPostUtil;
import com.google.gson.Gson;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyPostUtil.Biaoti{
    private ViewPager vp;
    private List<String> list;
    private MagicIndicator mag;
    private List<Fragment> frag = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        initview();
        x.view().inject(this);
        MyPostUtil post=new MyPostUtil();
        post.Post(this);


    }

    private void initview() {
        mag = (MagicIndicator) findViewById(R.id.mag);
        vp = (ViewPager) findViewById(R.id.support);
    }

    private void initdata() {
       list = new ArrayList<>();
       MyPostUtil post=new MyPostUtil();
        post.Post(this);


       /* list.add("推荐");list.add("热点");list.add("本地");list.add("视频");list.add("社会");
        list.add("娱乐");list.add("科技");list.add("汽车");list.add("体育");list.add("财经");*/
        frag.add(new Fragment1(MyUrl.path,"jinritouxiaotoutiao"));
        frag.add(new Fragment1(MyUrl.path2,"jinritoutiaoshehui"));frag.add(new Fragment1(MyUrl.path3,"jinritoutiao"));
        frag.add(new Fragment1(MyUrl.path4,"jinritoutiaoguoji"));frag.add(new Fragment1(MyUrl.path5,"jinritoutiaoyule"));
        frag.add(new Fragment1(MyUrl.path6,"jinritoutiaotiyu"));frag.add(new Fragment1(MyUrl.path7,"jinritoutiaojunshi"));
        frag.add(new Fragment1(MyUrl.path8,"jinritoutiaokeji"));frag.add(new Fragment1(MyUrl.path9,"jinritoutiaocaijing"));
        frag.add(new Fragment1(MyUrl.path10,"jinritoutiaoshishang"));





    }

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Titles title = gson.fromJson(result, Titles.class);
        List<Titles.ResultBean.DateBean> data = title.getResult().getDate();
        TopNewsDB tdb = new TopNewsDB();
        for (int i = 0; i < data.size(); i++) {
            TopNews tp = new TopNews();
            tp.setUri(data.get(i).getUri());
            tp.setTitle(data.get(i).getTitle());
            tdb.savePerson(tp);
        }

        List<TopNews> tlist = TopNewsDB.loadPerson();
        for (TopNews top : tlist) {
            Log.d("tag", "-------" + top.toString());
                list.add(top.getTitle());

        }
        CommonNavigator commongator = new CommonNavigator(MainActivity.this);

       commongator.setAdapter(new CommonNavigatorAdapter() {
           private ClipPagerTitleView clipagertitle;
           @Override
           public int getCount() {
               return list == null ? 0 : list.size();
           }

           @Override
           public IPagerTitleView getTitleView(Context context, final int index) {
               clipagertitle = new ClipPagerTitleView(context);
               clipagertitle.setTextSize(50);
               clipagertitle.setText(list.get(index));
               clipagertitle.setTextColor(Color.BLACK);
               clipagertitle.setClipColor(Color.RED);
               clipagertitle.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       vp.setCurrentItem(index);
                   }
               });
               return clipagertitle;
           }

           @Override
           public IPagerIndicator getIndicator(Context context) {
               LinePagerIndicator indictor=new LinePagerIndicator(MainActivity.this);
               indictor.setColors(Color.RED);
               return indictor;

           }
       });
        mag.setNavigator(commongator);
        MypagerAdapter my = new MypagerAdapter(getSupportFragmentManager(),frag);
        vp.setAdapter(my);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mag.onPageScrolled(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                mag.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mag.onPageScrollStateChanged(state);
            }
        });



            }


        }

