package com.reoky.crackme.challengefour.listeners;

import android.view.View;

import com.reoky.crackme.challengefour.R;
import com.reoky.crackme.challengefour.fragments.ChallengeFourFragment;

/**
 * Simple listener class to listen for events on ChallengeFourFragment
 * author: Lucas Thoresen
 */
public class ChallengeFourFragmentOnClickListener implements View.OnClickListener {

    private ChallengeFourFragment fragment;

    // Since we're not using an anonymous OnClickListener, but rather a named outer OnClickListener
    public ChallengeFourFragmentOnClickListener(ChallengeFourFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onClick(View view) {
        View parent = (View) view.getParent().getParent(); // TextGuess is in the parent parent view
        switch (view.getId()) {
            // Check to see whether the phone is in the GPS fenced area
            case R.id.challenge_four_button_check:
                fragment.checkLocation();
                break;
        }
    }
}
