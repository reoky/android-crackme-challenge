package com.reoky.crackme.challengenine.listeners;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.reoky.crackme.challengenine.R;

/**
 * Listener for the toggle switch on the hint fragment
 */
public class HintFragmentOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
    TextView textHint;

    public HintFragmentOnCheckedChangeListener(TextView textHint) {
        this.textHint = textHint;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int newVisibility = isChecked ? View.VISIBLE : View.GONE;
        if (textHint != null) {
            textHint.setVisibility(newVisibility);
        }
    }
}
