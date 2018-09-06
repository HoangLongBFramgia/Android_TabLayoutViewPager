package hoanglong.framgia.com.android_tablayoutviewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hoanglong.framgia.com.android_tablayoutviewpager.fragment.HomeFragment;
import hoanglong.framgia.com.android_tablayoutviewpager.fragment.TrendingFragment;
import hoanglong.framgia.com.android_tablayoutviewpager.fragment.UserFragment;
import hoanglong.framgia.com.android_tablayoutviewpager.utils.Constant;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new TrendingFragment();
                break;
            case 2:
                fragment = new UserFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = Constant.TITLE_HOME;
                break;
            case 1:
                title = Constant.TITLE_TRENDING;
                break;
            case 2:
                title = Constant.TITLE_USER;
                break;
        }
        return title;

    }
}
