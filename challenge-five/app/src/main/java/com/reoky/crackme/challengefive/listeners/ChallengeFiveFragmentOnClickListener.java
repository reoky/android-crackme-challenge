package com.reoky.crackme.challengefive.listeners;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reoky.crackme.challengefive.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Simple listener class to listen for events on ChallengeFiveFragment
 * author: Lucas Thoresen
 */
public class ChallengeFiveFragmentOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        View parent = (View) view.getParent().getParent(); // TextGuess is in the parent parent view
        switch (view.getId()) {
            case R.id.challenge_five_button_check:
                if (parent != null) {
                    EditText textGuess = (EditText) parent.findViewById(R.id.challenge_five_text_guess);
                    if (textGuess.getText().toString().toLowerCase().equals(view.getResources().getString(R.string.eight))) {
                        textGuess.setTextColor(parent.getResources().getColor(R.color.color_nebula));
                        Vibrator vibrator = (Vibrator) parent.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(1400);
                        Toast.makeText(parent.getContext(), view.getResources().getString(R.string.string_challenge_five_win), Toast.LENGTH_LONG).show();
                    } else {
                        textGuess.setTextColor(parent.getResources().getColor(R.color.color_nebula_dark));
                        Toast.makeText(parent.getContext(), view.getResources().getString(R.string.string_challenge_five_lose), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
