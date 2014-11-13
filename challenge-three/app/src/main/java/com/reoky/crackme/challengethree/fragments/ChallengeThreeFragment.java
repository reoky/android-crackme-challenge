package com.reoky.crackme.challengethree.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.reoky.crackme.challengethree.R;
import com.reoky.crackme.challengethree.model.PageSearchBundle;
import com.reoky.crackme.challengethree.tasks.PageSearch;
import com.reoky.crackme.challengethree.listeners.ChallengeThreeFragmentOnClickListener;

public class ChallengeThreeFragment extends Fragment {

    private TextView textCountdown;
    private ProgressBar progressCircle;
    private Handler handler = new Handler();

    private double delay; // Delay for this attempt and starting value for the countdown
    public static int attempt; // The refresh attempt number (1..5)
    public static double countdown; // Counter until next attempt

    public static TextView textPageContent;

    public ChallengeThreeFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressCircle = (ProgressBar) getActivity().findViewById(R.id.progress_circle);
        textCountdown = (TextView) getActivity().findViewById(R.id.text_countdown);
        textPageContent = (TextView) getActivity().findViewById(R.id.text_page_content);

        // Kick off the runnable timer
        handler.postDelayed(runnable, 0);

        // Set a click handler for manual refreshing via tap
        LinearLayout progressContainer = (LinearLayout) getActivity().findViewById(R.id.progress_container);
        progressContainer.setOnClickListener(new ChallengeThreeFragmentOnClickListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_three, container, false);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            // Calculate the amount of time to wait before next refresh
            // 10ln((x^x) , 1 < x < 5
            if (countdown <= 0.0) {
                if (attempt < 5) { attempt++; } else { handler.removeCallbacks(runnable); }
                delay = 10.0 * (int) Math.log(Math.pow(attempt, attempt));
                countdown = delay;

                // The counter hit zero so we should kick off the AsyncTask that
                // searches rit.edu again
                new PageSearch().execute(new PageSearchBundle(
                        getActivity().getApplicationContext(),
                        getResources().getString(R.string.string_challenge_three_url),
                        getResources().getString(R.string.string_challenge_three_keyword)
                ));
            }

            // Set progress and TextView text
            textCountdown.setText(String.format("Next Try: %.1f", countdown));
            int percent = (int)(100 - (100.0 * countdown/delay));
            progressCircle.setProgress(percent);

            // Decrement countdown
            countdown = countdown - 0.1;
            handler.postDelayed(this, 100);
        }
    };

}
