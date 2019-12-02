package com.szymonkaczmarek.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

import java.util.Random;

public class ClassicGameActivity extends AppCompatActivity {


    ImageButton button0, button1, button2, button3, button4, button5, button6, button7, button8, replayBtn, homeBtn;
    ImageView gameOverLineImage;
    TextView resultsDraw, resultsPlayerWin, resultsPlayerLost, circleStarts, crossStarts;
    final GameClassic newGame = new GameClassic();
    boolean isGameOver = false, notDraw = false;
    int whoseTurn = 0;
    private AdView mAdView;
    AdHelper adHelper = new AdHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        button0 = (ImageButton) findViewById(R.id.button0);
        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);
        button5 = (ImageButton) findViewById(R.id.button5);
        button6 = (ImageButton) findViewById(R.id.button6);
        button7 = (ImageButton) findViewById(R.id.button7);
        button8 = (ImageButton) findViewById(R.id.button8);
        replayBtn = (ImageButton) findViewById(R.id.replayButton);
        homeBtn = (ImageButton) findViewById(R.id.homeButton);
        resultsDraw = (TextView) findViewById(R.id.resultsTextViewDraw);
        gameOverLineImage = (ImageView) findViewById(R.id.gameOverLine);
        resultsPlayerWin = (TextView) findViewById(R.id.resultsTextViewPlayerWin);
        resultsPlayerLost = (TextView) findViewById(R.id.resultsTextViewPlayerTwoWin);
        crossStarts = (TextView) findViewById(R.id.crossStartsTextView);
        circleStarts = (TextView) findViewById(R.id.circleStartsTextView);
        mAdView = (AdView) findViewById(R.id.adViewActivityMain);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button0,0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button1,1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button2,2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button3,3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button4,4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button5,5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button6,6);
            }

        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button7,7);

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button8,8);
            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassicGameActivity.this, StartUpActivity.class);
                startActivity(intent);
            }
        });

        Random randomGenerator = new Random();
        whoseTurn = randomGenerator.nextInt(2);

        if(whoseTurn == 1){
            circleStarts.setVisibility(View.VISIBLE);
            computerMove();
        }
        else{
            crossStarts.setVisibility(View.VISIBLE);
        }

        adHelper.setupAds(getApplicationContext(), mAdView);

    }

    void playerMove(ImageButton buttonVar, int buttonNumber){
        newGame.playerTurn(buttonNumber);
        setImageCross(buttonVar);
        buttonVar.setEnabled(false);
        endGameDraw();
        endGameNoDraw();
        crossStarts.setVisibility(View.INVISIBLE);
        circleStarts.setVisibility(View.INVISIBLE);
        if(!isGameOver)
            computerMove();
    }

    int randomOneToTen(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10)+1;
    }

    void setImageCircle(ImageButton buttonVar){
        int randomNumber = randomOneToTen();
        if(randomNumber == 1){
            buttonVar.setImageResource(R.drawable.o1);
        }else if (randomNumber == 2){
            buttonVar.setImageResource(R.drawable.o2);
        }else if (randomNumber == 3){
            buttonVar.setImageResource(R.drawable.o3);
        }else if (randomNumber == 4){
            buttonVar.setImageResource(R.drawable.o4);
        }else if (randomNumber == 5){
            buttonVar.setImageResource(R.drawable.o5);
        }else if (randomNumber == 6){
            buttonVar.setImageResource(R.drawable.o6);
        }else if (randomNumber == 7){
            buttonVar.setImageResource(R.drawable.o7);
        }else if (randomNumber == 8){
            buttonVar.setImageResource(R.drawable.o8);
        }else if (randomNumber == 9){
            buttonVar.setImageResource(R.drawable.o9);
        }else if (randomNumber == 10){
            buttonVar.setImageResource(R.drawable.o10);
        }
    }

    void setImageCross(ImageButton buttonVar){
        int randomNumber = randomOneToTen();
        if(randomNumber == 1){
            buttonVar.setImageResource(R.drawable.x1);
        }else if (randomNumber == 2){
            buttonVar.setImageResource(R.drawable.x2);
        }else if (randomNumber == 3){
            buttonVar.setImageResource(R.drawable.x3);
        }else if (randomNumber == 4){
            buttonVar.setImageResource(R.drawable.x4);
        }else if (randomNumber == 5){
            buttonVar.setImageResource(R.drawable.x5);
        }else if (randomNumber == 6){
            buttonVar.setImageResource(R.drawable.x6);
        }else if (randomNumber == 7){
            buttonVar.setImageResource(R.drawable.x7);
        }else if (randomNumber == 8){
            buttonVar.setImageResource(R.drawable.x8);
        }else if (randomNumber == 9){
            buttonVar.setImageResource(R.drawable.x9);
        }else if (randomNumber == 10){
            buttonVar.setImageResource(R.drawable.x10);
        }
    }



    void computerMove(){

        int moveMinusOne = newGame.computerTurn(newGame.getGameField());

        if(moveMinusOne == 1){
            setImageCircle(button1);
            button1.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 2){
            setImageCircle(button2);
            button2.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 3){
            setImageCircle(button3);
            button3.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 4){
            setImageCircle(button4);
            button4.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 5){
            setImageCircle(button5);
            button5.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 6){
            setImageCircle(button6);
            button6.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 7){
            setImageCircle(button7);
            button7.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 0){
            setImageCircle(button0);
            button0.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }else if(moveMinusOne == 8){
            setImageCircle(button8);
            button8.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }
    }


    void alertPopUp(String title, String message){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Play again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

    void gameOverPlayerWonLine(){
        int gameOverLine = newGame.playerWonDrawLine(newGame.getGameField());

        if(gameOverLine == 1){
            gameOverLineImage.setImageResource(R.drawable.e012);
        }else if(gameOverLine == 2){
            gameOverLineImage.setImageResource(R.drawable.e345);
        }else if(gameOverLine == 3){
            gameOverLineImage.setImageResource(R.drawable.e678);
        }else if(gameOverLine == 4){
            gameOverLineImage.setImageResource(R.drawable.e036);
        }else if(gameOverLine == 5){
            gameOverLineImage.setImageResource(R.drawable.e147);
        }else if(gameOverLine == 6){
            gameOverLineImage.setImageResource(R.drawable.e258);
        }else if(gameOverLine == 7){
            gameOverLineImage.setImageResource(R.drawable.e048);
        }else if(gameOverLine == 8){
            gameOverLineImage.setImageResource(R.drawable.e246);
        }
        gameOverScreen();
        resultsPlayerWin.setVisibility(View.VISIBLE);


    }

    void gameOverComputerWonLine(){
        int gameOverLine = newGame.computerWonDrawLine(newGame.getGameField());

        if(gameOverLine == 1){
            gameOverLineImage.setImageResource(R.drawable.e012);
        }else if(gameOverLine == 2){
            gameOverLineImage.setImageResource(R.drawable.e345);
        }else if(gameOverLine == 3){
            gameOverLineImage.setImageResource(R.drawable.e678);
        }else if(gameOverLine == 4){
            gameOverLineImage.setImageResource(R.drawable.e036);
        }else if(gameOverLine == 5){
            gameOverLineImage.setImageResource(R.drawable.e147);
        }else if(gameOverLine == 6){
            gameOverLineImage.setImageResource(R.drawable.e258);
        }else if(gameOverLine == 7){
            gameOverLineImage.setImageResource(R.drawable.e048);
        }else if(gameOverLine == 8){
            gameOverLineImage.setImageResource(R.drawable.e246);
        }
        gameOverScreen();
        resultsPlayerLost.setVisibility(View.VISIBLE);

    }

    void gameOverScreen(){
        replayBtn.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.VISIBLE);
    }

    void gameOverDraw(){
        gameOverScreen();
        resultsDraw.setVisibility(View.VISIBLE);
    }


    void resetGame(){
        button0.setEnabled(true);
        button0.setImageResource(R.drawable.blank);
        button1.setEnabled(true);
        button1.setImageResource(R.drawable.blank);
        button2.setEnabled(true);
        button2.setImageResource(R.drawable.blank);
        button3.setEnabled(true);
        button3.setImageResource(R.drawable.blank);
        button4.setEnabled(true);
        button4.setImageResource(R.drawable.blank);
        button5.setEnabled(true);
        button5.setImageResource(R.drawable.blank);
        button6.setEnabled(true);
        button6.setImageResource(R.drawable.blank);
        button7.setEnabled(true);
        button7.setImageResource(R.drawable.blank);
        button8.setEnabled(true);
        button8.setImageResource(R.drawable.blank);
        gameOverLineImage.setImageResource(R.drawable.blank_end);
        isGameOver = false;
        resultsPlayerWin.setVisibility(View.INVISIBLE);
        resultsPlayerLost.setVisibility(View.INVISIBLE);
        replayBtn.setVisibility(View.INVISIBLE);
        homeBtn.setVisibility(View.INVISIBLE);
        resultsDraw.setVisibility(View.INVISIBLE);
        newGame.resetGame();
        Random randomGenerator = new Random();
        whoseTurn = randomGenerator.nextInt(2);
        if(whoseTurn==1) {
            computerMove();
            circleStarts.setVisibility(View.VISIBLE);
        }else{
            crossStarts.setVisibility(View.VISIBLE);
        }


    }

    void gameOver(){
        isGameOver = true;
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
    }

    void endGameDraw(){
        if(newGame.isDraw(newGame.getGameField())){
            gameOverDraw();
            gameOver();
        }
    }

    void endGameNoDraw(){
        if(newGame.didComputerWin(newGame.getGameField())){
            notDraw = true;
            gameOverComputerWonLine();
            gameOver();

        }
        else if(newGame.didPlayerWin(newGame.getGameField())){
            gameOverPlayerWonLine();
            gameOver();
        }
    }
}