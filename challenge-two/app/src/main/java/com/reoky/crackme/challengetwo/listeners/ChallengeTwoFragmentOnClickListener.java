package com.reoky.crackme.challengetwo.listeners;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.reoky.crackme.challengetwo.R;
import com.reoky.crackme.challengetwo.util.Digest;

/**
 * Simple listener class to listen for events on ChallengeTwoFragment
 * author: Lucas Thoresen
 */
public class ChallengeTwoFragmentOnClickListener implements View.OnClickListener {

    private String TAG = "ChallengeTwoFragment";

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.challenge_two_button_check:
                View parent = (View) view.getParent();
                EditText txtEmail = (EditText) parent.findViewById(R.id.challenge_two_text_email);
                EditText pwSecret = (EditText) parent.findViewById(R.id.challenge_two_text_secret);
                FrameLayout formError = (FrameLayout) parent.findViewById(R.id.corpnet_form_error);

                // Get the text values from EditTexts
                String email = txtEmail.getText().toString();
                String secret = Digest.md5Sum(pwSecret.getText().toString());

                if (email.equals("manager@corp.net")) {
                    if (secret.equals("b2c4782f0afc0d9ccf21af70ac6c5c7e")) {
                        txtEmail.setTextColor(view.getResources().getColor(R.color.color_nebula));
                        pwSecret.setTextColor(view.getResources().getColor(R.color.color_nebula));
                        Vibrator vibrator = (Vibrator) parent.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);
                        Toast.makeText(view.getContext(), "You\'ve completed this challenge!", Toast.LENGTH_LONG).show();
                        Toast.makeText(view.getContext(), "Leaving debug code in your applications can be dangerous, let alone unsalted password hashes.", Toast.LENGTH_LONG).show();
                    } else {
                        Log.d(TAG, "[WARN] Secret didn't match b2c4782f0afc0d9ccf21af70ac6c5c7e");
                    }

                } else {
                   Log.d(TAG, "[WARN] No such user...");
                   formError.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
