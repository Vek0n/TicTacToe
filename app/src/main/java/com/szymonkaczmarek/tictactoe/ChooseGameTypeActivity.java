package com.szymonkaczmarek.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdView;

public class ChooseGameTypeActivity extends AppCompatActivity {

    ImageButton PvPButton, PvCButton, difficultyButton, howToPlayButton;
    static int difficultyLevel = 1;
    static String gameType = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_game_type);

        PvPButton = (ImageButton) findViewById(R.id.twoPlayers);
        PvCButton = (ImageButton) findViewById(R.id.onePlayer);
        difficultyButton = (ImageButton) findViewById(R.id.difficultyButton);
        howToPlayButton = (ImageButton) findViewById(R.id.howToPlay);
        difficultyLevel = 1;
        howToPlayButton.setVisibility(View.INVISIBLE);
        if(gameType.equals("misere")){
            howToPlayButton.setVisibility(View.VISIBLE);
        }

        howToPlayButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    howToPlayButton.setImageResource(R.drawable.how_to_play_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    howToPlayButton.setImageResource(R.drawable.how_to_play);

                    helpDialog();


                    return true;
                }
                return false;
            }
        });

        PvPButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    PvPButton.setImageResource(R.drawable.two_players_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    PvPButton.setImageResource(R.drawable.two_players);

                    if(gameType.equals("classic")) {
                        Intent intent = new Intent(ChooseGameTypeActivity.this, PlayerVsPlayerClassicGameActivity.class);
                        startActivity(intent);
                    } else if (gameType.equals("fourByFour")) {
                        Intent intent = new Intent(ChooseGameTypeActivity.this, PlayerVsPlayerFourByFourActivity.class);
                        startActivity(intent);
                    } else if(gameType.equals("misere")){
                        Intent intent = new Intent(ChooseGameTypeActivity.this, PlayerVsPlayerMisereActivity.class);
                        startActivity(intent);
                    }

                    return true;
                }
                return false;
            }
        });


        PvCButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    PvCButton.setImageResource(R.drawable.one_player_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    PvCButton.setImageResource(R.drawable.one_player);

                    if(gameType.equals("classic")) {
                        Intent intent = new Intent(ChooseGameTypeActivity.this, ClassicGameActivity.class);
                        startActivity(intent);
                    }else if(gameType.equals("fourByFour")){
                        Intent intent = new Intent(ChooseGameTypeActivity.this, FourByFourGameActivity.class);
                        startActivity(intent);
                    }else if(gameType.equals("misere")) {
                        Intent intent = new Intent(ChooseGameTypeActivity.this, MisereGameActivity.class);
                        startActivity(intent);
                    }

                    return true;
                }
                return false;
            }
        });

        difficultyButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    difficultyButton.setImageResource(R.drawable.easy);

                    difficultyLevel++;
                    if(difficultyLevel == 2){
                        difficultyButton.setImageResource(R.drawable.medium);
                    }else if(difficultyLevel == 3){
                        difficultyButton.setImageResource(R.drawable.hard);
                    }else{
                        difficultyLevel = 1;
                        difficultyButton.setImageResource(R.drawable.easy);
                    }

                    return true;
                }
                return false;
            }
        });
    }

    void helpDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        String title = getResources().getString(R.string.titleHelpDialog);
        String dialogText = getResources().getString(R.string.helpDialogText);
        String closeDialog = getResources().getString(R.string.closeDialog);
        alertDialog.setTitle(title);
        alertDialog.setMessage(dialogText);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, closeDialog,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
