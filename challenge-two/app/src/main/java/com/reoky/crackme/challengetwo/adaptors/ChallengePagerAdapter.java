package com.reoky.crackme.challengetwo.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.reoky.crackme.challengetwo.fragments.AboutFragment;
import com.reoky.crackme.challengetwo.fragments.ChallengeTwoFragment;
import com.reoky.crackme.challengetwo.fragments.HintFragment;

public class ChallengePagerAdapter extends FragmentPagerAdapter {

    public ChallengePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChallengeTwoFragment();
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