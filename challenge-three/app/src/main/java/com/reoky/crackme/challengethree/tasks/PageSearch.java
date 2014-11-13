package com.reoky.crackme.challengethree.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.widget.Toast;

import com.reoky.crackme.challengethree.R;
import com.reoky.crackme.challengethree.fragments.ChallengeThreeFragment;
import com.reoky.crackme.challengethree.model.PageSearchBundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class was implemented to search a page or multiple pages for a string
 * when you pass to it one or more PageSearchBundles
 * <ParamType, ProgressType, ResultType>
 */
public class PageSearch extends AsyncTask<PageSearchBundle, Void, PageSearchBundle> {

    /*
     * System calls this method on the background thread after onPreExecute()
     * which is not implemented/needed here
     */
    @Override
    protected PageSearchBundle doInBackground(PageSearchBundle... bundles) {
        Boolean result = false;

        for (PageSearchBundle bundle : bundles) {
            try {
                URL url = new URL(bundle.getUrl());
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(),
                        "UTF-8"
                ));

                StringBuilder pageContent = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    pageContent.append(line);
                }

                bufferedReader.close();

                // Stop at the first match instead of wasting cpu cycles
                if (pageContent.toString().contains(bundle.getKeyword())) {
                    return bundle;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // No bundles matched their keywords
        return null;
    }

    /*
     * System calls this method on the UI thread after background thread exits
     */
    @Override
    protected void onPostExecute(PageSearchBundle bundle) {
        super.onPostExecute(bundle);

        // Did a bundle match or did we just get null?
        if (bundle != null) {
            Context context = bundle.getContext();
            ChallengeThreeFragment.textPageContent.setText(context.getResources().getText(R.string.string_challenge_three_complete));
            ChallengeThreeFragment.textPageContent.setTextColor(context.getResources().getColor(R.color.color_nebula_light));

            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1400);
            Toast.makeText(context, context.getResources().getText(R.string.string_challenge_three_complete_msg_zero), Toast.LENGTH_LONG).show();
            Toast.makeText(context, context.getResources().getText(R.string.string_challenge_three_complete_msg_one), Toast.LENGTH_LONG).show();
        }
    }
}
