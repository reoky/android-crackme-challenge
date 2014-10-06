package com.reoky.crackme.challengefive.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.reoky.crackme.challengefive.fragments.AboutFragment;
import com.reoky.crackme.challengefive.fragments.ChallengeFiveFragment;
import com.reoky.crackme.challengefive.fragments.HintFragment;

public class ChallengePagerAdapter extends FragmentPagerAdapter {

    public ChallengePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChallengeFiveFragment();
            case 1:
                return new HintFragment();
            default:
                return new AboutFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}