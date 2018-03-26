package com.example.nambd.bai1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by NamBD on 3/26/2018.
 */

public class FramgmentAdapter extends FragmentPagerAdapter {
    public FramgmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RectangularFragment.newInstance();
            case 1:
                return SquareFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Hình Chữ Nhật";
            case 1:
                return "Hình Vuông";
            default:
                return null;
        }
    }
}
