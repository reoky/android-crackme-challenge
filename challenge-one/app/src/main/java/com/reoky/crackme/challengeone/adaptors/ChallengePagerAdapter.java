package com.reoky.crackme.challengeone.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.reoky.crackme.challengeone.fragments.AboutFragment;
import com.reoky.crackme.challengeone.fragments.ChallengeOneFragment;
import com.reoky.crackme.challengeone.fragments.HintFragment;

public class ChallengePagerAdapter extends FragmentPagerAdapter {

    public ChallengePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChallengeOneFragment();
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