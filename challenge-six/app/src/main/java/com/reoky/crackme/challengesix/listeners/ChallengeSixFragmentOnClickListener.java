package com.reoky.crackme.challengesix.listeners;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reoky.crackme.challengesix.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Simple listener class to listen for events on ChallengeSixFragment
 * author: Lucas Thoresen
 */
public class ChallengeSixFragmentOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        View parent = (View) view.getParent().getParent(); // TextGuess is in the parent parent view
        switch (view.getId()) {
            case R.id.challenge_one_button_check:

                if (parent != null) {
                    EditText textGuess = (EditText) parent.findViewById(R.id.challenge_one_text_guess);

                    // Check to see if the user beat the challenge. The code that was here before was
                    // silly. (And actually for a different type of challenge)
                    if (textGuess.getText().toString().toLowerCase().equals("poorly-protected-secret")) {
                        textGuess.setTextColor(parent.getResources().getColor(R.color.color_nebula));
                        Vibrator vibrator = (Vibrator) parent.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(400);
                        Toast.makeText(parent.getContext(), "You\'ve completed this challenge!", Toast.LENGTH_LONG).show();
                    } else {
                        textGuess.setTextColor(parent.getResources().getColor(R.color.color_nebula_dark));
                        Toast.makeText(parent.getContext(), "Sorry, that\'s not right..", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button_write_file:
                final Button buttonWrite = (Button) parent.findViewById(R.id.button_write_file);

                // Check to see if the file already exists
                File file = view.getContext().getFileStreamPath("ANSWER");
                if (file.exists()) {
                    file.delete();
                    buttonWrite.setText(R.string.string_challenge_write_file);
                    Toast.makeText(parent.getContext(), "File Deleted", Toast.LENGTH_LONG).show();

                } else {
                    try {
                        FileOutputStream fileOutputStream = parent.getContext().openFileOutput("ANSWER", Context.MODE_WORLD_READABLE);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        outputStreamWriter.write("poorly-protected-secret");
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        Toast.makeText(parent.getContext(), "File Written", Toast.LENGTH_LONG).show();
                    }
                    catch (FileNotFoundException e) { e.printStackTrace(); }
                    catch (IOException e) { e.printStackTrace(); }

                    // Change the text on the button to delete
                    buttonWrite.setText(R.string.string_challenge_delete_file);
                }
                break;
        }
    }
}
