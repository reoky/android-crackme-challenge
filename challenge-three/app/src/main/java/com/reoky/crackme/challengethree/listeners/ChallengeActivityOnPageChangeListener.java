package com.reoky.crackme.challengethree.listeners;

import android.app.ActionBar;
import android.support.v4.view.ViewPager;

/**
 * Class to handle tab changes after a gesture for ChallengeActivity
 */
public class ChallengeActivityOnPageChangeListener extends ViewPager.SimpleOnPageChangeListener {

    ActionBar actionBar;

    public ChallengeActivityOnPageChangeListener(ActionBar actionBar){
        this.actionBar = actionBar;
    }

    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }
}
