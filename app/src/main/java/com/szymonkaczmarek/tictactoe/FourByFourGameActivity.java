package com.szymonkaczmarek.tictactoe;

import android.content.Intent;
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

public class FourByFourGameActivity extends AppCompatActivity {

    ImageButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, replayBtn, homeBtn;
    ImageView gameOverLineImage;
    TextView resultsDraw, resultsPlayerWin, resultsPlayerLost,crossStarts,circleStarts;

    final GameFourByFour gameFourByFour = new GameFourByFour();
    boolean isGameOver = false;
    int whoseTurn = 0;
    private AdView mAdView;
    AdHelper adHelper = new AdHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_four_by_four_tic_tac_toe);

        button0 = (ImageButton) findViewById(R.id.imageButton0);
        button1 = (ImageButton) findViewById(R.id.imageButton1);
        button2 = (ImageButton) findViewById(R.id.imageButton2);
        button3 = (ImageButton) findViewById(R.id.imageButton3);
        button4 = (ImageButton) findViewById(R.id.imageButton4);
        button5 = (ImageButton) findViewById(R.id.imageButton5);
        button6 = (ImageButton) findViewById(R.id.imageButton6);
        button7 = (ImageButton) findViewById(R.id.imageButton7);
        button8 = (ImageButton) findViewById(R.id.imageButton8);
        button9 = (ImageButton) findViewById(R.id.imageButton9);
        button10 = (ImageButton) findViewById(R.id.imageButton10);
        button11 = (ImageButton) findViewById(R.id.imageButton11);
        button12 = (ImageButton) findViewById(R.id.imageButton12);
        button13 = (ImageButton) findViewById(R.id.imageButton13);
        button14 = (ImageButton) findViewById(R.id.imageButton14);
        button15 = (ImageButton) findViewById(R.id.imageButton15);
        replayBtn = (ImageButton) findViewById(R.id.replayButton);
        homeBtn = (ImageButton) findViewById(R.id.homeButton);
        resultsDraw = (TextView) findViewById(R.id.resultsTextViewDraw);
        gameOverLineImage = (ImageView) findViewById(R.id.gameOverLine);
        resultsPlayerWin = (TextView) findViewById(R.id.resultsTextViewPlayerWin);
        resultsPlayerLost = (TextView) findViewById(R.id.resultsTextViewPlayerTwoWin);
        crossStarts = (TextView) findViewById(R.id.crossStartsTextView);
        circleStarts = (TextView) findViewById(R.id.circleStartsTextView);
        mAdView = (AdView) findViewById(R.id.adViewFourByFour);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button0, 0);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button1, 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button2, 2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button3, 3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button4, 4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button5, 5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button6, 6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button7, 7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button8, 8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button9, 9);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button10, 10);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button11, 11);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button12, 12);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button13, 13);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button14, 14);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerMove(button15, 15);
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
                Intent intent = new Intent(FourByFourGameActivity.this, StartUpActivity.class);
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


    void playerMove(ImageButton buttonVar, int buttonNumber) {
        gameFourByFour.playerTurn(buttonNumber);
        setImageCross(buttonVar);
        buttonVar.setEnabled(false);
        endGameDraw();
        endGameNoDraw();
        crossStarts.setVisibility(View.INVISIBLE);
        circleStarts.setVisibility(View.INVISIBLE);
        if (!isGameOver)
            computerMove();
    }

    int randomOneToTen() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10) + 1;
    }

    void setImageCircle(ImageButton buttonVar) {
        int randomNumber = randomOneToTen();
        if (randomNumber == 1) {
            buttonVar.setImageResource(R.drawable.o1s);
        } else if (randomNumber == 2) {
            buttonVar.setImageResource(R.drawable.o2s);
        } else if (randomNumber == 3) {
            buttonVar.setImageResource(R.drawable.o3s);
        } else if (randomNumber == 4) {
            buttonVar.setImageResource(R.drawable.o4s);
        } else if (randomNumber == 5) {
            buttonVar.setImageResource(R.drawable.o5s);
        } else if (randomNumber == 6) {
            buttonVar.setImageResource(R.drawable.o6s);
        } else if (randomNumber == 7) {
            buttonVar.setImageResource(R.drawable.o7s);
        } else if (randomNumber == 8) {
            buttonVar.setImageResource(R.drawable.o8s);
        } else if (randomNumber == 9) {
            buttonVar.setImageResource(R.drawable.o9s);
        } else if (randomNumber == 10) {
            buttonVar.setImageResource(R.drawable.o10s);
        }
    }

    void setImageCross(ImageButton buttonVar) {
        int randomNumber = randomOneToTen();
        if (randomNumber == 1) {
            buttonVar.setImageResource(R.drawable.x1s);
        } else if (randomNumber == 2) {
            buttonVar.setImageResource(R.drawable.x2s);
        } else if (randomNumber == 3) {
            buttonVar.setImageResource(R.drawable.x3s);
        } else if (randomNumber == 4) {
            buttonVar.setImageResource(R.drawable.x4s);
        } else if (randomNumber == 5) {
            buttonVar.setImageResource(R.drawable.x5s);
        } else if (randomNumber == 6) {
            buttonVar.setImageResource(R.drawable.x6s);
        } else if (randomNumber == 7) {
            buttonVar.setImageResource(R.drawable.x7s);
        } else if (randomNumber == 8) {
            buttonVar.setImageResource(R.drawable.x8s);
        } else if (randomNumber == 9) {
            buttonVar.setImageResource(R.drawable.x9s);
        } else if (randomNumber == 10) {
            buttonVar.setImageResource(R.drawable.x10s);
        }
    }

    void computerMove() {

        int moveMinusOne = gameFourByFour.computerTurn(gameFourByFour.getGameField());

        if (moveMinusOne == 1) {
            setImageCircle(button1);
            button1.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 2) {
            setImageCircle(button2);
            button2.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 3) {
            setImageCircle(button3);
            button3.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 4) {
            setImageCircle(button4);
            button4.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 5) {
            setImageCircle(button5);
            button5.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 6) {
            setImageCircle(button6);
            button6.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 7) {
            setImageCircle(button7);
            button7.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 0) {
            setImageCircle(button0);
            button0.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 8) {
            setImageCircle(button8);
            button8.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 9) {
            setImageCircle(button9);
            button9.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 10) {
            setImageCircle(button10);
            button10.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 11) {
            setImageCircle(button11);
            button11.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 12) {
            setImageCircle(button12);
            button12.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 13) {
            setImageCircle(button13);
            button13.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 14) {
            setImageCircle(button14);
            button14.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        } else if (moveMinusOne == 15) {
            setImageCircle(button15);
            button15.setEnabled(false);
            endGameDraw();
            endGameNoDraw();
        }
    }

    void gameOver() {
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
        button9.setEnabled(false);
        button10.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button15.setEnabled(false);
    }

    void gameOverPlayerWonLine() {
        int gameOverLine = gameFourByFour.playerWonDrawLine(gameFourByFour.getGameField());

        if (gameOverLine == 1) {
            gameOverLineImage.setImageResource(R.drawable.e0123);
        } else if (gameOverLine == 2) {
            gameOverLineImage.setImageResource(R.drawable.e4567);
        } else if (gameOverLine == 3) {
            gameOverLineImage.setImageResource(R.drawable.e891011);
        } else if (gameOverLine == 4) {
            gameOverLineImage.setImageResource(R.drawable.e12131415);
        } else if (gameOverLine == 5) {
            gameOverLineImage.setImageResource(R.drawable.e04812);
        } else if (gameOverLine == 6) {
            gameOverLineImage.setImageResource(R.drawable.e15913);
        } else if (gameOverLine == 7) {
            gameOverLineImage.setImageResource(R.drawable.e261014);
        } else if (gameOverLine == 8) {
            gameOverLineImage.setImageResource(R.drawable.e371115);
        } else if (gameOverLine == 9) {
            gameOverLineImage.setImageResource(R.drawable.e051015);
        } else if (gameOverLine == 10) {
            gameOverLineImage.setImageResource(R.drawable.e36912);
        }
        gameOverScreen();
        resultsPlayerWin.setVisibility(View.VISIBLE);
    }

    void gameOverComputerWonLine() {
        int gameOverLine = gameFourByFour.computerWonDrawLine(gameFourByFour.getGameField());

        if (gameOverLine == 1) {
            gameOverLineImage.setImageResource(R.drawable.e0123);
        } else if (gameOverLine == 2) {
            gameOverLineImage.setImageResource(R.drawable.e4567);
        } else if (gameOverLine == 3) {
            gameOverLineImage.setImageResource(R.drawable.e891011);
        } else if (gameOverLine == 4) {
            gameOverLineImage.setImageResource(R.drawable.e12131415);
        } else if (gameOverLine == 5) {
            gameOverLineImage.setImageResource(R.drawable.e04812);
        } else if (gameOverLine == 6) {
            gameOverLineImage.setImageResource(R.drawable.e15913);
        } else if (gameOverLine == 7) {
            gameOverLineImage.setImageResource(R.drawable.e261014);
        } else if (gameOverLine == 8) {
            gameOverLineImage.setImageResource(R.drawable.e371115);
        } else if (gameOverLine == 9) {
            gameOverLineImage.setImageResource(R.drawable.e051015);
        } else if (gameOverLine == 10) {
            gameOverLineImage.setImageResource(R.drawable.e36912);
        }
        gameOverScreen();
        resultsPlayerLost.setVisibility(View.VISIBLE);
    }


    void resetGame() {
        button0.setEnabled(true);
        button0.setImageResource(R.drawable.blank_75x75);
        button1.setEnabled(true);
        button1.setImageResource(R.drawable.blank_75x75);
        button2.setEnabled(true);
        button2.setImageResource(R.drawable.blank_75x75);
        button3.setEnabled(true);
        button3.setImageResource(R.drawable.blank_75x75);
        button4.setEnabled(true);
        button4.setImageResource(R.drawable.blank_75x75);
        button5.setEnabled(true);
        button5.setImageResource(R.drawable.blank_75x75);
        button6.setEnabled(true);
        button6.setImageResource(R.drawable.blank_75x75);
        button7.setEnabled(true);
        button7.setImageResource(R.drawable.blank_75x75);
        button9.setEnabled(true);
        button9.setImageResource(R.drawable.blank_75x75);
        button10.setEnabled(true);
        button10.setImageResource(R.drawable.blank_75x75);
        button11.setEnabled(true);
        button11.setImageResource(R.drawable.blank_75x75);
        button12.setEnabled(true);
        button12.setImageResource(R.drawable.blank_75x75);
        button13.setEnabled(true);
        button13.setImageResource(R.drawable.blank_75x75);
        button14.setEnabled(true);
        button14.setImageResource(R.drawable.blank_75x75);
        button15.setEnabled(true);
        button15.setImageResource(R.drawable.blank_75x75);
        button8.setEnabled(true);
        button8.setImageResource(R.drawable.blank_75x75);
        gameOverLineImage.setImageResource(R.drawable.eblank4s4);
        isGameOver = false;
        resultsPlayerWin.setVisibility(View.INVISIBLE);
        resultsPlayerLost.setVisibility(View.INVISIBLE);
        replayBtn.setVisibility(View.INVISIBLE);
        homeBtn.setVisibility(View.INVISIBLE);
        resultsDraw.setVisibility(View.INVISIBLE);
        gameFourByFour.resetGame();
        Random randomGenerator = new Random();
        whoseTurn = randomGenerator.nextInt(2);
        if(whoseTurn==1) {
            computerMove();
            circleStarts.setVisibility(View.VISIBLE);
        }else{
            crossStarts.setVisibility(View.VISIBLE);
        }
    }

    void gameOverScreen() {
        replayBtn.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.VISIBLE);
    }

    void gameOverDraw() {
        gameOverScreen();
        resultsDraw.setVisibility(View.VISIBLE);
    }

    void endGameDraw() {
        if (gameFourByFour.isDraw(gameFourByFour.getGameField())) {
            gameOverDraw();
            gameOver();
        }
    }

    void endGameNoDraw() {
        if (gameFourByFour.didComputerWin(gameFourByFour.getGameField())) {
            gameOverComputerWonLine();
            gameOver();
        } else if (gameFourByFour.didPlayerWin(gameFourByFour.getGameField())) {
            gameOverPlayerWonLine();
            gameOver();
        }
    }
}
