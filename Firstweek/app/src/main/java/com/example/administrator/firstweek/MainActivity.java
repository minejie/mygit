package com.example.administrator.firstweek;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
    private String uri = "http://result.eolinker.com/KLn5hSP9f6fed196f92ec0148255a48aebb2c6cc5f97f0e?uri=user";

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRightMenu();
        ListView lv  = (ListView) findViewById(R.id.lv);

        MyAnsycTask myAnsycTask = new MyAnsycTask(this, lv);
        myAnsycTask.execute(uri);

    }
    private void initRightMenu()
    {

        Fragment leftMenuFragment = new Left();

        setBehindContentView(R.layout.left);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fra, leftMenuFragment).commit();
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        // menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        // menu.setBehindScrollScale(1.0f);
        // menu.setSecondaryShadowDrawable(R.drawable.shadow);
        //设置右边（二级）侧滑菜单
        menu.setSecondaryMenu(R.layout.right);
        Fragment rightMenuFragment = new Right();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr, rightMenuFragment).commit();
    }
    public void showLeftMenu(View view)
    {
        getSlidingMenu().showMenu();
    }

    public void showRightMenu(View view)
    {
        getSlidingMenu().showSecondaryMenu();
    }

}
