package com.reoky.crackme.challengetwo.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.reoky.crackme.challengetwo.R;
import com.reoky.crackme.challengetwo.adaptors.ChallengePagerAdapter;
import com.reoky.crackme.challengetwo.listeners.ChallengeActivityOnPageChangeListener;

public class ChallengeActivity extends FragmentActivity implements ActionBar.TabListener {

    ChallengePagerAdapter mChallengePagerAdapter;
    ViewPager mViewPager;
    ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        mChallengePagerAdapter = new ChallengePagerAdapter(getSupportFragmentManager());
        actionBar = getActionBar();

        // Configure the action barW
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // Configure the ViewPager and attach a
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mChallengePagerAdapter);
        mViewPager.setOnPageChangeListener(new ChallengeActivityOnPageChangeListener(actionBar));

        // Load a tab for each section
        actionBar.addTab(actionBar.newTab().setText("Challenge").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Hint").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("About").setTabListener(this));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition()); // Tell ViewPager to change fragments
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
}
