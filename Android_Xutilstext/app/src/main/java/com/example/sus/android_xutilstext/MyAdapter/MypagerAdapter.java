package com.example.sus.android_xutilstext.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/10.
 */

public class MypagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();

    public MypagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public MypagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }
}
