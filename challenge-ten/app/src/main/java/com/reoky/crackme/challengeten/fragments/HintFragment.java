package com.reoky.crackme.challengeten.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.reoky.crackme.challengeten.R;
import com.reoky.crackme.challengeten.listeners.HintFragmentOnCheckedChangeListener;

public class HintFragment extends Fragment {

    public HintFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hint, container, false);
        final ToggleButton switchShowHint = (ToggleButton) view.findViewById(R.id.switch_show_hint);
        switchShowHint.setOnCheckedChangeListener(new HintFragmentOnCheckedChangeListener((TextView) view.findViewById(R.id.text_hint)));
        return view;
    }

}
