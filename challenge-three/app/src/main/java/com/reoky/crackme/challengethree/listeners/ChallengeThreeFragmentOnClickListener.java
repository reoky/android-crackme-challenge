package com.reoky.crackme.challengethree.listeners;

import android.view.View;
import android.widget.LinearLayout;

import com.reoky.crackme.challengethree.R;
import com.reoky.crackme.challengethree.fragments.ChallengeThreeFragment;

/**
 * Simple listener class to listen for events on ChallengeThreeFragment
 * author: Lucas Thoresen
 */
public class ChallengeThreeFragmentOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.progress_container:
                ChallengeThreeFragment.attempt = 1;
                ChallengeThreeFragment.countdown = 0.0;
                break;
        }
    }
}
