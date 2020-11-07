package com.keerushar.pushme;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;
    Context context;

    public PagerAdapter(Context context, FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new workout_defin();
            case 1:
                return new classic_workout();
            case 2:
                return new abs_workout();
            case 3:
                return new arm_workout();
            case 4:
                return new leg_workout();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}



