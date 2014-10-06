package com.reoky.crackme.challengethree.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reoky.crackme.challengethree.R;
import com.reoky.crackme.challengethree.listeners.AboutFragmentOnClickListener;

public class AboutFragment extends Fragment {

    public AboutFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the view
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Handle the quit button being pressed
        final Button quitButton = (Button) view.findViewById(R.id.button_quit);
        quitButton.setOnClickListener(new AboutFragmentOnClickListener());

        return view;
    }

}
