package com.szymonkaczmarek.tictactoe;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class StartUpActivity extends AppCompatActivity {

    ImageButton playClassicModeButton, playFourByFour,playMisere, shareBtn, rateBtn, feedbackBtn;
    //private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_up);



        playClassicModeButton = (ImageButton) findViewById(R.id.buttonPlayClassicMode);
        playFourByFour = (ImageButton) findViewById(R.id.buttonPlayFourByFourMode);
        playMisere = (ImageButton) findViewById(R.id.buttonPlayMisereMode);
        shareBtn = (ImageButton) findViewById(R.id.shareButton);
        rateBtn = (ImageButton) findViewById(R.id.rateButton);
        feedbackBtn = (ImageButton) findViewById(R.id.feedbackButton);

        feedbackBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    feedbackBtn.setImageResource(R.drawable.feedback_button_pressed2);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    feedbackBtn.setImageResource(R.drawable.feedback_button2);
                    sendFeedback();
                    return true;
                }
                return false;
            }
        });

        rateBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    rateBtn.setImageResource(R.drawable.rate_app_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    rateBtn.setImageResource(R.drawable.rate_app);
                    rateIt();
                    return true;
                }
                return false;
            }
        });

        shareBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    shareBtn.setImageResource(R.drawable.share_button_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    shareBtn.setImageResource(R.drawable.share_button);
                    shareIt();
                    return true;
                }
                return false;
            }
        });

        playClassicModeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playClassicModeButton.setImageResource(R.drawable.classic_mode_button_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    playClassicModeButton.setImageResource(R.drawable.classic_mode_button);

                    ChooseGameTypeActivity.gameType = "classic";
                    Intent intent = new Intent(StartUpActivity.this, ChooseGameTypeActivity.class);
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });


        playFourByFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    playFourByFour.setImageResource(R.drawable.four_by_four_mode_pressed);

                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    playFourByFour.setImageResource(R.drawable.four_by_four_mode);

                    ChooseGameTypeActivity.gameType = "fourByFour";
                    Intent intent = new Intent(StartUpActivity.this, ChooseGameTypeActivity.class);
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });


        playMisere.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    playMisere.setImageResource(R.drawable.misere_mode_pressed);

                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    playMisere.setImageResource(R.drawable.misere_mode);

                    ChooseGameTypeActivity.gameType = "misere";
                    Intent intent = new Intent(StartUpActivity.this, ChooseGameTypeActivity.class);
                    startActivity(intent);

                    return true;
                }

                return false;
            }
        });

//        MobileAds.initialize(getApplicationContext(),
//                ClassicGameActivity.tylda);
//        mAdView = (AdView) findViewById(R.id.adViewStartUpActivity);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


    }

    private void shareIt(){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getResources().getString(R.string.shareBody);
        String subject = getResources().getString(R.string.subjectRateApp);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        String shareVia = getResources().getString(R.string.shareVia);
        startActivity(Intent.createChooser(sharingIntent, shareVia));
    }

    private void rateIt(){
        Uri uri = Uri.parse("market://details?id=" + getBaseContext().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getBaseContext(), "Sorry, Not able to open!", Toast.LENGTH_LONG).show();
        }
    }

    private void sendFeedback(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"s.kaczmarek084@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        i.putExtra(Intent.EXTRA_TEXT   , "");
        try {
            startActivity(Intent.createChooser(i, "Choose email client"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

}