package com.reoky.crackme.challengetwo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.reoky.crackme.challengetwo.R;
import com.reoky.crackme.challengetwo.listeners.ChallengeTwoFragmentOnClickListener;

public class ChallengeTwoFragment extends Fragment {

    public ChallengeTwoFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Make a user directory
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_two, container, false);

        // Handle authentication attempts
        final Button btnCheck = (Button) view.findViewById(R.id.challenge_two_button_check);
        btnCheck.setOnClickListener(new ChallengeTwoFragmentOnClickListener());

        // Hide the form error message until the user actually has an error
        final FrameLayout formError = (FrameLayout) view.findViewById(R.id.corpnet_form_error);
        formError.setVisibility(View.GONE);

        return view;
    }
}
