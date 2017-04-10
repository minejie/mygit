package firstweek.zhoukao.czj.zhoukaoyi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import firstweek.zhoukao.czj.zhoukaoyi.OneFragment;


public class Myadapter extends FragmentPagerAdapter {
    private List<Fragment> myfragment;


    public Myadapter(FragmentManager fm, List<Fragment> myfragment) {
        super(fm);
        this.myfragment = myfragment;

    }

    public Myadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return myfragment.get(position);
    }

    @Override
    public int getCount() {
        return myfragment.size();
    }
}
