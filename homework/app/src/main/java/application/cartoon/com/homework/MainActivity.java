package application.cartoon.com.homework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import application.cartoon.com.homework.frag.FragmentContent;
import application.cartoon.com.homework.frag.Left;
import application.cartoon.com.homework.utils.Url;

public class MainActivity extends AppCompatActivity implements Left.OnLeftItemClick{
private TextView tv;
    int oldPosi;
    private FragmentManager fm;
    private List<Fragment> frag;
private ImageView left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        initData();
        initView();


    }

    private void initData() {
        frag = new ArrayList<>();
        FragmentContent content1=new FragmentContent();
        content1.url= Url.AllURL;
        frag.add(content1);

        FragmentContent content2=new FragmentContent();
        content2.url= Url.EASTURL;
        frag.add(content2);

        FragmentContent content3=new FragmentContent();
        content3.url= Url.WESTURL;
        frag.add(content3);
    }

    private void initView() {
tv= (TextView) findViewById(R.id.text);
        left= (ImageView) findViewById(R.id.btn_left);
        final SlidingMenu menu=new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/3);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.left_menu);
        Left left_frag=new Left();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.lf,left_frag);
        left_frag.setOnLeftItemClick(this);
        transaction.commit();
        addOrshow(0);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.showMenu();
            }
        });
    }
private void addOrshow(int positon){
    Fragment byTag = fm.findFragmentByTag("tag" + positon);

    FragmentTransaction transaction = fm.beginTransaction();
    if (byTag!=null){
       transaction.show(byTag);
    }
    else {
       transaction.add(R.id.fl, frag.get(positon),"tag"+positon);

    }
    transaction.commit();
oldPosi=positon;
    }
    private void hide(int positon){
        Fragment byTag = fm.findFragmentByTag("tag" + positon);

        FragmentTransaction transaction = fm.beginTransaction();
        if (byTag!=null){
            transaction.hide(byTag);
        }

    transaction.commit();
    }

    @Override
    public void itemClick(String title, int positon) {
hide(oldPosi);
        addOrshow(positon);
        tv.setText(title);
    }
}
