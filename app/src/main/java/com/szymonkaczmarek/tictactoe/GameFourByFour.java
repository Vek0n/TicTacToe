package com.szymonkaczmarek.tictactoe;

import java.util.Random;

/**
 * Created by szymonkaczmarek on 09.08.2017.
 */

public class GameFourByFour extends Game{

    private int[] gameField = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    public int[] getGameField(){return gameField;}

    public int randomComputerMove(int[] gameField) {
        Random randomGenerator = new Random();
        int move = randomGenerator.nextInt(16);
        while (true) {
            if (isFieldEmpty(gameField, move)) {
                break;
            } else {
                move = randomGenerator.nextInt(16);
            }
        }
        return move;
    }


    public void resetGame(){
        int[] gameField = getGameField();
        for(int i=0; i<16; i++){
            gameField[i]=2;
        }
    }

    public boolean isDraw(int[] gameField){
        boolean boardFull = true;
        for(int i=0; i<16; i++){
            if(gameField[i]==2){
                boardFull = false;
            }
        }
        if(boardFull) {
            if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1 && gameField [3] == 1)
                return false;
            else if (gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 1 && gameField [7] == 1)
                return false;
            else if (gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 1 && gameField [11] == 1)
                return false;
            else if (gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 1 && gameField [15] == 1)
                return false;
            else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1 && gameField [12] == 1)
                return false;
            else if (gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 1 && gameField [13] == 1)
                return false;
            else if (gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 1 && gameField [14] == 1)
                return false;
            else if (gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 1 && gameField [15] == 1)
                return false;
            else if (gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 1 && gameField [15] == 1)
                return false;
            else if (gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 1 && gameField [12] == 1)
                return false;
            else if(gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0 && gameField [3] == 0)
                return false;
            else if (gameField[4] == 0 && gameField[5] == 0 && gameField[6] == 0 && gameField [7] == 0)
                return false;
            else if (gameField[8] == 0 && gameField[9] == 0 && gameField[10] == 0 && gameField [11] == 0)
                return false;
            else if (gameField[12] == 0 && gameField[13] == 0 && gameField[14] == 0 && gameField [15] == 0)
                return false;
            else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0 && gameField [12] == 0)
                return false;
            else if (gameField[1] == 0 && gameField[5] == 0 && gameField[9] == 0 && gameField [13] == 0)
                return false;
            else if (gameField[2] == 0 && gameField[6] == 0 && gameField[10] == 0 && gameField [14] == 0)
                return false;
            else if (gameField[3] == 0 && gameField[7] == 0 && gameField[11] == 0 && gameField [15] == 0)
                return false;
            else if (gameField[0] == 0 && gameField[5] == 0 && gameField[10] == 0 && gameField [15] == 0)
                return false;
            else if (gameField[3] == 0 && gameField[6] == 0 && gameField[9] == 0 && gameField [12] == 0)
                return false;

            else return true;
        }
        return false;
    }

   public boolean didComputerWin(int[] gameField){
        if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1 && gameField [3] == 1)
            return true;
        else if (gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 1 && gameField [7] == 1)
            return true;
        else if (gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 1 && gameField [11] == 1)
            return true;
        else if (gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 1 && gameField [15] == 1)
            return true;
        else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1 && gameField [12] == 1)
            return true;
        else if (gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 1 && gameField [13] == 1)
            return true;
        else if (gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 1 && gameField [14] == 1)
            return true;
        else if (gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 1 && gameField [15] == 1)
            return true;
        else if (gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 1 && gameField [15] == 1)
            return true;
        else if (gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 1 && gameField [12] == 1)
            return true;

        else return false;
    }

    boolean didPlayerWin(int[] gameField){
        if(gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0 && gameField [3] == 0)
            return true;
        else if (gameField[4] == 0 && gameField[5] == 0 && gameField[6] == 0 && gameField [7] == 0)
            return true;
        else if (gameField[8] == 0 && gameField[9] == 0 && gameField[10] == 0 && gameField [11] == 0)
            return true;
        else if (gameField[12] == 0 && gameField[13] == 0 && gameField[14] == 0 && gameField [15] == 0)
            return true;
        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0 && gameField [12] == 0)
            return true;
        else if (gameField[1] == 0 && gameField[5] == 0 && gameField[9] == 0 && gameField [13] == 0)
            return true;
        else if (gameField[2] == 0 && gameField[6] == 0 && gameField[10] == 0 && gameField [14] == 0)
            return true;
        else if (gameField[3] == 0 && gameField[7] == 0 && gameField[11] == 0 && gameField [15] == 0)
            return true;
        else if (gameField[0] == 0 && gameField[5] == 0 && gameField[10] == 0 && gameField [15] == 0)
            return true;
        else if (gameField[3] == 0 && gameField[6] == 0 && gameField[9] == 0 && gameField [12] == 0)
            return true;

        else return false;
    }

    private int isDanger(int[] gameField){
        if(gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0 && gameField[3] == 2)
            return 3;
        else if (gameField[4] == 0 && gameField[5] == 0 && gameField[6] == 0 && gameField[7] == 2)
            return 7;
        else if (gameField[8] == 0 && gameField[9] == 0 && gameField[10] == 0 && gameField[11] == 2)
            return 11;
        else if (gameField[12] == 0 && gameField[13] == 0 && gameField[14] == 0 && gameField[15] == 2)
            return 15;

        else if (gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 2 && gameField[3] == 0)
            return 2;
        else if (gameField[4] == 0 && gameField[5] == 0 && gameField[6] == 2 && gameField[7] == 0)
            return 6;
        else if (gameField[8] == 0 && gameField[9] == 0 && gameField[10] == 2 && gameField[11] == 0)
            return 10;
        else if (gameField[12] == 0 && gameField[13] == 0 && gameField[14] == 2 && gameField[15] == 0)
            return 14;

        else if (gameField[0] == 0 && gameField[1] == 2 && gameField[2] == 0 && gameField[3] == 0)
            return 1;
        else if (gameField[4] == 0 && gameField[5] == 2 && gameField[6] == 0 && gameField[7] == 0)
            return 5;
        else if (gameField[8] == 0 && gameField[9] == 2 && gameField[10] == 0 && gameField[11] == 0)
            return 9;
        else if (gameField[12] == 0 && gameField[13] == 2 && gameField[14] == 0 && gameField[15] == 0)
            return 13;

        else if (gameField[0] == 2 && gameField[1] == 0 && gameField[2] == 0 && gameField[3] == 0)
            return 0;
        else if (gameField[4] == 2 && gameField[5] == 0 && gameField[6] == 0 && gameField[7] == 0)
            return 4;
        else if (gameField[8] == 2 && gameField[9] == 0 && gameField[10] == 0 && gameField[11] == 0)
            return 8;
        else if (gameField[12] == 2 && gameField[13] == 0 && gameField[14] == 0 && gameField[15] == 0)
            return 12;




        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0 && gameField[12] == 2)
            return 12;
        else if (gameField[1] == 0 && gameField[5] == 0 && gameField[9] == 0 && gameField[13] == 2)
            return 13;
        else if (gameField[2] == 0 && gameField[6] == 0 && gameField[10] == 0 && gameField[14] == 2)
            return 14;
        else if (gameField[3] == 0 && gameField[7] == 0 && gameField[11] == 0 && gameField[15] == 2)
            return 15;

        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 2 && gameField[12] == 0)
            return 8;
        else if (gameField[1] == 0 && gameField[5] == 0 && gameField[9] == 2 && gameField[13] == 0)
            return 9;
        else if (gameField[2] == 0 && gameField[6] == 0 && gameField[10] == 2 && gameField[14] == 0)
            return 10;
        else if (gameField[3] == 0 && gameField[7] == 0 && gameField[11] == 2 && gameField[15] == 0)
            return 11;

        else if (gameField[0] == 0 && gameField[4] == 2 && gameField[8] == 0 && gameField[12] == 0)
            return 4;
        else if (gameField[1] == 0 && gameField[5] == 2 && gameField[9] == 0 && gameField[13] == 0)
            return 5;
        else if (gameField[2] == 0 && gameField[6] == 2 && gameField[10] == 0 && gameField[14] == 0)
            return 6;
        else if (gameField[3] == 0 && gameField[7] == 2 && gameField[11] == 0 && gameField[15] == 0)
            return 7;

        else if (gameField[0] == 2 && gameField[4] == 0 && gameField[8] == 0 && gameField[12] == 0)
            return 0;
        else if (gameField[1] == 2 && gameField[5] == 0 && gameField[9] == 0 && gameField[13] == 0)
            return 1;
        else if (gameField[2] == 2 && gameField[6] == 0 && gameField[10] == 0 && gameField[14] == 0)
            return 2;
        else if (gameField[3] == 2 && gameField[7] == 0 && gameField[11] == 0 && gameField[15] == 0)
            return 3;



        else if (gameField[0] == 0 && gameField[5] == 0 && gameField[10] == 0 && gameField[15] == 2)
            return 15;
        else if (gameField[0] == 0 && gameField[5] == 0 && gameField[10] == 2 && gameField[15] == 0)
            return 10;
        else if (gameField[0] == 0 && gameField[5] == 2 && gameField[10] == 0 && gameField[15] == 0)
            return 5;
        else if (gameField[0] == 2 && gameField[5] == 0 && gameField[10] == 0 && gameField[15] == 0)
            return 0;


        else if (gameField[3] == 0 && gameField[6] == 0 && gameField[9] == 0 && gameField[12] == 2)
            return 12;
        else if (gameField[3] == 0 && gameField[6] == 0 && gameField[9] == 2 && gameField[12] == 0)
            return 9;
        else if (gameField[3] == 0 && gameField[6] == 2 && gameField[9] == 0 && gameField[12] == 0)
            return 6;
        else if (gameField[3] == 2 && gameField[6] == 0 && gameField[9] == 0 && gameField[12] == 0)
            return 3;

        else return 50;
    }

    private int randomSecondMoveHorizontal(int a, int b){
        Random randomGenerator = new Random();
        while(true) {
            int move = randomGenerator.nextInt(4) + a;
            if (move != b)
                return move;
        }
    }
    private int randomSecondMoveVertical(int a, int b, int c){
        int[] arr = {a,b,c};
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(3);
        return arr[index];
    }
    private int randomThirdMoveArray(int a, int b){
        int[] arr = {a,b};
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(2);
        return arr[index];
    }
    private int isPossibleToWin(int[]gameField){

        ///////////////POZIOMO///////////////
        if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1 && gameField[3] == 2)
            return 3;
        else if (gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 2 && gameField[3] == 1)
            return 2;
        else if(gameField[0] == 1 && gameField[1] == 2 && gameField[2] == 1 && gameField[3] == 1)
            return 1;
        else if (gameField[0] == 2 && gameField[1] == 1 && gameField[2] == 1 && gameField[3] == 1)
            return 0;


        else if(gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 1 && gameField[7] == 2)
            return 7;
        else if (gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 2 && gameField[7] == 1)
            return 6;
        else if(gameField[4] == 1 && gameField[5] == 2 && gameField[6] == 1 && gameField[7] == 1)
            return 5;
        else if (gameField[4] == 2 && gameField[5] == 1 && gameField[6] == 1 && gameField[7] == 1)
            return 4;

        else if(gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 1 && gameField[11] == 2)
            return 11;
        else if (gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 2 && gameField[11] == 1)
            return 10;
        else if(gameField[8] == 1 && gameField[9] == 2 && gameField[10] == 1 && gameField[11] == 1)
            return 9;
        else if (gameField[8] == 2 && gameField[9] == 1 && gameField[10] == 1 && gameField[11] == 1)
            return 8;


        else if(gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 1 && gameField[15] == 2)
            return 15;
        else if (gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 2 && gameField[15] == 1)
            return 14;
        else if(gameField[12] == 1 && gameField[13] == 2 && gameField[14] == 1 && gameField[15] == 1)
            return 13;
        else if (gameField[12] == 2 && gameField[13] == 1 && gameField[14] == 1 && gameField[15] == 1)
            return 12;
        ////////////POZIOMO - koniec///////////////

        ////////////PIONOWO////////////////////////
        else if(gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1 && gameField[12] == 2)
            return 12;
        else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 2 && gameField[12] == 1)
            return 8;
        else if(gameField[0] == 1 && gameField[4] == 2 && gameField[8] == 1 && gameField[12] == 1)
            return 4;
        else if (gameField[0] == 2 && gameField[4] == 1 && gameField[8] == 1 && gameField[12] == 1)
            return 0;


        else if(gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 1 && gameField[13] == 2)
            return 13;
        else if (gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 2 && gameField[13] == 1)
            return 9;
        else if(gameField[1] == 1 && gameField[5] == 2 && gameField[9] == 1 && gameField[13] == 1)
            return 5;
        else if (gameField[1] == 2 && gameField[5] == 1 && gameField[9] == 1 && gameField[13] == 1)
            return 1;


        else if(gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 1 && gameField[14] == 2)
            return 14;
        else if (gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 2 && gameField[14] == 1)
            return 10;
        else if(gameField[2] == 1 && gameField[6] == 2 && gameField[10] == 1 && gameField[14] == 1)
            return 6;
        else if (gameField[2] == 2 && gameField[6] == 1 && gameField[10] == 1 && gameField[14] == 1)
            return 2;


        else if(gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 1 && gameField[15] == 2)
            return 15;
        else if (gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 2 && gameField[15] == 1)
            return 11;
        else if(gameField[3] == 1 && gameField[7] == 2 && gameField[11] == 1 && gameField[15] == 1)
            return 7;
        else if (gameField[3] == 2 && gameField[7] == 1 && gameField[11] == 1 && gameField[15] == 1)
            return 3;
        //////////////////PIONOWO - koniec////////////


        //////////////SKOŚNE//////////////
        else if(gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 1 && gameField[15] == 2)
            return 15;
        else if (gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 2 && gameField[15] == 1)
            return 10;
        else if(gameField[0] == 1 && gameField[5] == 2 && gameField[10] == 1 && gameField[15] == 1)
            return 5;
        else if (gameField[0] == 2 && gameField[5] == 1 && gameField[10] == 1 && gameField[15] == 1)
            return 0;


        else if(gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 1 && gameField[12] == 2)
            return 12;
        else if (gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 2 && gameField[12] == 1)
            return 9;
        else if(gameField[3] == 1 && gameField[6] == 2 && gameField[9] == 1 && gameField[12] == 1)
            return 6;
        else if (gameField[3] == 2 && gameField[6] == 1 && gameField[9] == 1 && gameField[12] == 1)
            return 3;
        /////////////SKOŚNE - koniec/////////////
        return 50;
    }
    private int secondInRow(int [] gameField){
        Random randomGenerator = new Random();
       // if(getDirection()==0) {
        /////////////////////////POZIOMO//////////////////////////
        if (gameField[0] == 1 && gameField[1] == 2 && gameField[2] == 2 && gameField[3] == 2)
            return randomGenerator.nextInt(3) + 1;
        else if (gameField[0] == 2 && gameField[1] == 1 && gameField[2] == 2 && gameField[3] == 2)
            return randomSecondMoveHorizontal(0, 1);
        else if (gameField[0] == 2 && gameField[1] == 2 && gameField[2] == 1 && gameField[3] == 2)
            return randomSecondMoveHorizontal(0, 2);
        else if (gameField[0] == 2 && gameField[1] == 2 && gameField[2] == 2 && gameField[3] == 1)
            return randomSecondMoveHorizontal(0, 3);


        else if (gameField[4] == 1 && gameField[5] == 2 && gameField[6] == 2 && gameField[7] == 2)
            return randomGenerator.nextInt(3) + 5;
        else if (gameField[4] == 2 && gameField[5] == 1 && gameField[6] == 2 && gameField[7] == 2)
            return randomSecondMoveHorizontal(4, 5);
        else if (gameField[4] == 2 && gameField[5] == 2 && gameField[6] == 1 && gameField[7] == 2)
            return randomSecondMoveHorizontal(4, 6);
        else if (gameField[4] == 2 && gameField[5] == 2 && gameField[6] == 2 && gameField[7] == 1)
            return randomSecondMoveHorizontal(4, 7);


        else if (gameField[8] == 1 && gameField[9] == 2 && gameField[10] == 2 && gameField[11] == 2)
            return randomGenerator.nextInt(3) + 9;
        else if (gameField[8] == 2 && gameField[9] == 1 && gameField[10] == 2 && gameField[11] == 2)
            return randomSecondMoveHorizontal(8, 9);
        else if (gameField[8] == 2 && gameField[9] == 2 && gameField[10] == 1 && gameField[11] == 2)
            return randomSecondMoveHorizontal(8, 10);
        else if (gameField[8] == 2 && gameField[9] == 2 && gameField[10] == 2 && gameField[11] == 1)
            return randomSecondMoveHorizontal(8, 11);


        else if (gameField[12] == 1 && gameField[13] == 2 && gameField[14] == 2 && gameField[15] == 2)
            return randomGenerator.nextInt(3) + 13;
        else if (gameField[12] == 2 && gameField[13] == 1 && gameField[14] == 2 && gameField[15] == 2)
            return randomSecondMoveHorizontal(12, 13);
        else if (gameField[12] == 2 && gameField[13] == 2 && gameField[14] == 1 && gameField[15] == 2)
            return randomSecondMoveHorizontal(12, 14);
        else if (gameField[12] == 2 && gameField[13] == 2 && gameField[14] == 2 && gameField[15] == 1)
            return randomSecondMoveHorizontal(12, 15);
        ///////////////POZIOMO - koniec///////////////////
    //}else{


            //////////////PIONOWO////////////////////////////
        else if(gameField[0] == 1 && gameField[4] == 2 && gameField[8] == 2 && gameField[12] == 2)
                return randomSecondMoveVertical(4,8,12);
        else if(gameField[0] == 2 && gameField[4] == 1 && gameField[8] == 2 && gameField[12] == 2)
                return randomSecondMoveVertical(0,8,12);
        else if (gameField[0] == 2 && gameField[4] == 2 && gameField[8] == 1 && gameField[12] == 2)
            return randomSecondMoveVertical(0,4,12);
        else if (gameField[0] == 2 && gameField[4] == 2 && gameField [8] == 2 && gameField[12] == 1)
            return randomSecondMoveVertical(0,4,8);


        else if(gameField[1] == 1 && gameField[5] == 2 && gameField[9] == 2 && gameField[13] == 2)
            return randomSecondMoveVertical(5,9,13);
        else if(gameField[1] == 2 && gameField[5] == 1 && gameField[9] == 2 && gameField[13] == 2)
            return randomSecondMoveVertical(1,9,13);
        else if (gameField[1] == 2 && gameField[5] == 2 && gameField[9] == 1 && gameField[13] == 2)
            return randomSecondMoveVertical(1,5,13);
        else if (gameField[1] == 2 && gameField[5] == 2 && gameField [9] == 2 && gameField[13] == 1)
            return randomSecondMoveVertical(1,5,9);


        else if(gameField[2] == 1 && gameField[6] == 2 && gameField[10] == 2 && gameField[14] == 2)
            return randomSecondMoveVertical(6,10,14);
        else if(gameField[2] == 2 && gameField[6] == 1 && gameField[10] == 2 && gameField[14] == 2)
            return randomSecondMoveVertical(2,10,14);
        else if (gameField[2] == 2 && gameField[6] == 2 && gameField[10] == 1 && gameField[14] == 2)
            return randomSecondMoveVertical(2,6,14);
        else if (gameField[2] == 2 && gameField[6] == 2 && gameField [10] == 2 && gameField[14] == 1)
            return randomSecondMoveVertical(2,6,10);


        else if(gameField[3] == 1 && gameField[7] == 2 && gameField[11] == 2 && gameField[15] == 2)
            return randomSecondMoveVertical(7,11,15);
        else if(gameField[3] == 2 && gameField[7] == 1 && gameField[11] == 2 && gameField[15] == 2)
            return randomSecondMoveVertical(3,11,15);
        else if (gameField[3] == 2 && gameField[7] == 2 && gameField[11] == 1 && gameField[15] == 2)
            return randomSecondMoveVertical(3,7,15);
        else if (gameField[3] == 2 && gameField[7] == 2 && gameField [11] == 2 && gameField[15] == 1)
            return randomSecondMoveVertical(3,7,11);

        ///////////////PIONOWO - koniec////////////////

        //////////////SKOŚNE///////////////////////
        else if(gameField[0] == 1 && gameField[5] == 2 && gameField[10] == 2 && gameField[15] == 2)
            return randomSecondMoveVertical(5,10,15);
        else if(gameField[0] == 2 && gameField[5] == 1 && gameField[10] == 2 && gameField[15] == 2)
            return randomSecondMoveVertical(0,10,15);
        else if (gameField[0] == 2 && gameField[5] == 2 && gameField[10] == 1 && gameField[15] == 2)
            return randomSecondMoveVertical(0,5,15);
        else if (gameField[0] == 2 && gameField[5] == 2 && gameField [10] == 2 && gameField[15] == 1)
            return randomSecondMoveVertical(0,5,10);


        else if(gameField[3] == 1 && gameField[6] == 2 && gameField[9] == 2 && gameField[12] == 2)
            return randomSecondMoveVertical(6,9,12);
        else if(gameField[3] == 2 && gameField[6] == 1 && gameField[9] == 2 && gameField[12] == 2)
            return randomSecondMoveVertical(3,9,12);
        else if (gameField[3] == 2 && gameField[6] == 2 && gameField[9] == 1 && gameField[12] == 2)
            return randomSecondMoveVertical(3,6,12);
        else if (gameField[3] == 2 && gameField[6] == 2 && gameField [9] == 2 && gameField[12] == 1)
            return randomSecondMoveVertical(3,6,9);
        ////////////SKOŚNE - koniec/////////////////
        else return 50;
    }
    private int thirdInRow(int[] gameField){
        //////////////////POZIOMO//////////////////////
        if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 2 && gameField[3] == 2)
            return randomThirdMoveArray(2,3);
        else if(gameField[0] == 1 && gameField[1] == 2 && gameField[2] == 1 && gameField[3] == 2)
            return randomThirdMoveArray(1,3);
        else if(gameField[0] == 1 && gameField[1] == 2 && gameField[2] == 2 && gameField[3] == 1)
            return randomThirdMoveArray(1,2);
        else if(gameField[0] == 2 && gameField[1] == 1 && gameField[2] == 1 && gameField[3] == 2)
            return randomThirdMoveArray(0,3);
        else if(gameField[0] == 2 && gameField[1] == 1 && gameField[2] == 2 && gameField[3] == 1)
            return randomThirdMoveArray(0,2);
        else if(gameField[0] == 2 && gameField[1] == 2 && gameField[2] == 1 && gameField[3] == 1)
            return randomThirdMoveArray(0,1);


        else if(gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 2 && gameField[7] == 2)
            return randomThirdMoveArray(6,7);
        else if(gameField[4] == 1 && gameField[5] == 2 && gameField[6] == 1 && gameField[7] == 2)
            return randomThirdMoveArray(5,7);
        else if(gameField[4] == 1 && gameField[5] == 2 && gameField[6] == 2 && gameField[7] == 1)
            return randomThirdMoveArray(5,6);
        else if(gameField[4] == 2 && gameField[5] == 1 && gameField[6] == 1 && gameField[7] == 2)
            return randomThirdMoveArray(4,7);
        else if(gameField[4] == 2 && gameField[5] == 1 && gameField[6] == 2 && gameField[7] == 1)
            return randomThirdMoveArray(4,6);
        else if(gameField[4] == 2 && gameField[5] == 2 && gameField[6] == 1 && gameField[7] == 1)
            return randomThirdMoveArray(4,5);


        else if(gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 2 && gameField[11] == 2)
            return randomThirdMoveArray(10,11);
        else if(gameField[8] == 1 && gameField[9] == 2 && gameField[10] == 1 && gameField[11] == 2)
            return randomThirdMoveArray(9,11);
        else if(gameField[8] == 1 && gameField[9] == 2 && gameField[10] == 2 && gameField[11] == 1)
            return randomThirdMoveArray(9,10);
        else if(gameField[8] == 2 && gameField[9] == 1 && gameField[10] == 1 && gameField[11] == 2)
            return randomThirdMoveArray(8,11);
        else if(gameField[8] == 2 && gameField[9] == 1 && gameField[10] == 2 && gameField[11] == 1)
            return randomThirdMoveArray(8,10);
        else if(gameField[8] == 2 && gameField[9] == 2 && gameField[10] == 1 && gameField[11] == 1)
            return randomThirdMoveArray(8,9);


        else if(gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 2 && gameField[15] == 2)
            return randomThirdMoveArray(14,15);
        else if(gameField[12] == 1 && gameField[13] == 2 && gameField[14] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(13,15);
        else if(gameField[12] == 1 && gameField[13] == 2 && gameField[14] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(13,14);
        else if(gameField[12] == 2 && gameField[13] == 1 && gameField[14] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(12,15);
        else if(gameField[12] == 2 && gameField[13] == 1 && gameField[14] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(12,14);
        else if(gameField[12] == 2 && gameField[13] == 2 && gameField[14] == 1 && gameField[15] == 1)
            return randomThirdMoveArray(12,13);
    ///////////////POZIOMO - koniec///////////////////

    ///////////////PIONOWO///////////////////////////

        else if(gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 2 && gameField[12] == 2)
            return randomThirdMoveArray(8,12);
        else if(gameField[0] == 1 && gameField[4] == 2 && gameField[8] == 1 && gameField[12] == 2)
            return randomThirdMoveArray(4,12);
        else if(gameField[0] == 1 && gameField[4] == 2 && gameField[8] == 2 && gameField[12] == 1)
            return randomThirdMoveArray(4,8);
        else if(gameField[0] == 2 && gameField[4] == 1 && gameField[8] == 1 && gameField[12] == 2)
            return randomThirdMoveArray(0,12);
        else if(gameField[0] == 2 && gameField[4] == 1 && gameField[8] == 2 && gameField[12] == 1)
            return randomThirdMoveArray(0,8);
        else if(gameField[0] == 2 && gameField[4] == 2 && gameField[8] == 1 && gameField[12] == 1)
            return randomThirdMoveArray(0,4);


        else if(gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 2 && gameField[13] == 2)
            return randomThirdMoveArray(9,13);
        else if(gameField[1] == 1 && gameField[5] == 2 && gameField[9] == 1 && gameField[13] == 2)
            return randomThirdMoveArray(5,13);
        else if(gameField[1] == 1 && gameField[5] == 2 && gameField[9] == 2 && gameField[13] == 1)
            return randomThirdMoveArray(5,9);
        else if(gameField[1] == 2 && gameField[5] == 1 && gameField[9] == 1 && gameField[13] == 2)
            return randomThirdMoveArray(1,13);
        else if(gameField[1] == 2 && gameField[5] == 1 && gameField[9] == 2 && gameField[13] == 1)
            return randomThirdMoveArray(1,9);
        else if(gameField[1] == 2 && gameField[5] == 2 && gameField[9] == 1 && gameField[13] == 1)
            return randomThirdMoveArray(1,5);


        else if(gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 2 && gameField[14] == 2)
            return randomThirdMoveArray(10,14);
        else if(gameField[2] == 1 && gameField[6] == 2 && gameField[10] == 1 && gameField[14] == 2)
            return randomThirdMoveArray(6,14);
        else if(gameField[2] == 1 && gameField[6] == 2 && gameField[10] == 2 && gameField[14] == 1)
            return randomThirdMoveArray(6,10);
        else if(gameField[2] == 2 && gameField[6] == 1 && gameField[10] == 1 && gameField[14] == 2)
            return randomThirdMoveArray(2,14);
        else if(gameField[2] == 2 && gameField[6] == 1 && gameField[10] == 2 && gameField[14] == 1)
            return randomThirdMoveArray(2,10);
        else if(gameField[2] == 2 && gameField[6] == 2 && gameField[10] == 1 && gameField[14] == 1)
            return randomThirdMoveArray(2,6);


        else if(gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 2 && gameField[15] == 2)
            return randomThirdMoveArray(11,15);
        else if(gameField[3] == 1 && gameField[7] == 2 && gameField[11] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(7,15);
        else if(gameField[3] == 1 && gameField[7] == 2 && gameField[11] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(7,11);
        else if(gameField[3] == 2 && gameField[7] == 1 && gameField[11] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(3,15);
        else if(gameField[3] == 2 && gameField[7] == 1 && gameField[11] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(3,11);
        else if(gameField[3] == 2 && gameField[7] == 2 && gameField[11] == 1 && gameField[15] == 1)
            return randomThirdMoveArray(3,7);


        /////////////////SKOŚNE///////////////
        else if(gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 2 && gameField[15] == 2)
            return randomThirdMoveArray(10,15);
        else if(gameField[0] == 1 && gameField[5] == 2 && gameField[10] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(5,15);
        else if(gameField[0] == 1 && gameField[5] == 2 && gameField[10] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(5,10);
        else if(gameField[0] == 2 && gameField[5] == 1 && gameField[10] == 1 && gameField[15] == 2)
            return randomThirdMoveArray(0,15);
        else if(gameField[0] == 2 && gameField[5] == 1 && gameField[10] == 2 && gameField[15] == 1)
            return randomThirdMoveArray(0,10);
        else if(gameField[0] == 2 && gameField[5] == 2 && gameField[10] == 1 && gameField[15] == 1)
            return randomThirdMoveArray(0,5);


        else if(gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 2 && gameField[12] == 2)
            return randomThirdMoveArray(9,12);
        else if(gameField[3] == 1 && gameField[6] == 2 && gameField[9] == 1 && gameField[12] == 2)
            return randomThirdMoveArray(6,12);
        else if(gameField[3] == 1 && gameField[6] == 2 && gameField[9] == 2 && gameField[12] == 1)
            return randomThirdMoveArray(6,9);
        else if(gameField[3] == 2 && gameField[6] == 1 && gameField[9] == 1 && gameField[12] == 2)
            return randomThirdMoveArray(3,12);
        else if(gameField[3] == 2 && gameField[6] == 1 && gameField[9] == 2 && gameField[12] == 1)
            return randomThirdMoveArray(6,9);
        else if(gameField[3] == 2 && gameField[6] == 2 && gameField[9] == 1 && gameField[12] == 1)
            return randomThirdMoveArray(3,6);
        /////////////SKOŚNE - koniec/////////////
        else return 50;
    }

    public int computerWonDrawLine(int[] gameField){
        if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1 && gameField [3] == 1)
            return 1;
        else if (gameField[4] == 1 && gameField[5] == 1 && gameField[6] == 1 && gameField [7] == 1)
            return 2;
        else if (gameField[8] == 1 && gameField[9] == 1 && gameField[10] == 1 && gameField [11] == 1)
            return 3;
        else if (gameField[12] == 1 && gameField[13] == 1 && gameField[14] == 1 && gameField [15] == 1)
            return 4;
        else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1 && gameField [12] == 1)
            return 5;
        else if (gameField[1] == 1 && gameField[5] == 1 && gameField[9] == 1 && gameField [13] == 1)
            return 6;
        else if (gameField[2] == 1 && gameField[6] == 1 && gameField[10] == 1 && gameField [14] == 1)
            return 7;
        else if (gameField[3] == 1 && gameField[7] == 1 && gameField[11] == 1 && gameField [15] == 1)
            return 8;
        else if (gameField[0] == 1 && gameField[5] == 1 && gameField[10] == 1 && gameField [15] == 1)
            return 9;
        else if (gameField[3] == 1 && gameField[6] == 1 && gameField[9] == 1 && gameField [12] == 1)
            return 10;

        else return 99;
    }

    public int playerWonDrawLine(int[] gameField){
        if(gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0 && gameField [3] == 0)
            return 1;
        else if (gameField[4] == 0 && gameField[5] == 0 && gameField[6] == 0 && gameField [7] == 0)
            return 2;
        else if (gameField[8] == 0 && gameField[9] == 0 && gameField[10] == 0 && gameField [11] == 0)
            return 3;
        else if (gameField[12] == 0 && gameField[13] == 0 && gameField[14] == 0 && gameField [15] == 0)
            return 4;
        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0 && gameField [12] == 0)
            return 5;
        else if (gameField[1] == 0 && gameField[5] == 0 && gameField[9] == 0 && gameField [13] == 0)
            return 6;
        else if (gameField[2] == 0 && gameField[6] == 0 && gameField[10] == 0 && gameField [14] == 0)
            return 7;
        else if (gameField[3] == 0 && gameField[7] == 0 && gameField[11] == 0 && gameField [15] == 0)
            return 8;
        else if (gameField[0] == 0 && gameField[5] == 0 && gameField[10] == 0 && gameField [15] == 0)
            return 9;
        else if (gameField[3] == 0 && gameField[6] == 0 && gameField[9] == 0 && gameField [12] == 0)
            return 10;

        else return 99;
    }


    public int computerTurn(int[] gameField){
        int move;

        if(isPossibleToWin(gameField) == 50){
            if(isDanger(gameField) == 50){
                if(thirdInRow(gameField)==50){
                    if(secondInRow(gameField) == 50){
                        move = randomComputerMove(gameField);
                        gameField[move] = 1;
                        return move;
                    }else{
                        move = secondInRow(gameField);
                        gameField[move] = 1;
                        return move;
                    }
                }else{
                    move = thirdInRow(gameField);
                    gameField[move] = 1;
                    return move;
                }
            }else{
                if(isMoveCorrect(65, 20)) {
                    move = isDanger(gameField);
                    gameField[move] = 1;
                    return move;
                }else{
                    move = randomComputerMove(gameField);
                    gameField[move] = 1;
                    return move;
                }
            }
        }else{
            move = isPossibleToWin(gameField);
            gameField[move] = 1;
            return move;
        }

    }
}
