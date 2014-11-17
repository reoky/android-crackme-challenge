package com.reoky.crackme.challengefive.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reoky.crackme.challengefive.R;
import com.reoky.crackme.challengefive.listeners.ChallengeFiveFragmentOnClickListener;

public class ChallengeFiveFragment extends Fragment {

    public ChallengeFiveFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_five, container, false);

        // Handle the user checking their answer
        final Button buttonCheck = (Button) view.findViewById(R.id.challenge_five_button_check);
        buttonCheck.setOnClickListener(new ChallengeFiveFragmentOnClickListener());

        return view;
    }
}
