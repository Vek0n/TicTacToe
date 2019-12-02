package com.szymonkaczmarek.tictactoe;

import java.util.Random;

/**
 * Created by szymonkaczmarek on 22.07.2017.
 */

public class GameMisere extends Game{

    private int[] gameField = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public int[] getGameField(){return gameField;}


    public void resetGame(){
        int[] gameField = getGameField();
        for(int i=0; i<9; i++){
            gameField[i]=2;
        }
    }

    boolean isGameOver (int[] gameField){
        if (gameField[0] != 2 && gameField[1] != 2 && gameField[2] != 2)
            return true;
        else if (gameField[3] != 2 && gameField[4] != 2 && gameField[5] != 2)
            return true;
        else if (gameField[6] != 2 && gameField[7] != 2 && gameField[8] != 2)
            return true;
        else if (gameField[0] != 2 && gameField[3] != 2 && gameField[6] != 2)
            return true;
        else if (gameField[1] != 2 && gameField[4] != 2 && gameField[7] != 2)
            return true;
        else if (gameField[2] != 2 && gameField[5] != 2 && gameField[8] != 2)
            return true;
        else if (gameField[0] != 2 && gameField[4] != 2 && gameField[8] != 2)
            return true;
        else if (gameField[2] != 2 && gameField[4] != 2 && gameField[6] != 2)
            return true;

        else return false;
    }

    int gameOverDrawLine (int[] gameField){
        if (gameField[0] != 2 && gameField[1] != 2 && gameField[2] != 2)
            return 1;
        else if (gameField[3] != 2 && gameField[4] != 2 && gameField[5] != 2)
            return 2;
        else if (gameField[6] != 2 && gameField[7] != 2 && gameField[8] != 2)
            return 3;
        else if (gameField[0] != 2 && gameField[3] != 2 && gameField[6] != 2)
            return 4;
        else if (gameField[1] != 2 && gameField[4] != 2 && gameField[7] != 2)
            return 5;
        else if (gameField[2] != 2 && gameField[5] != 2 && gameField[8] != 2)
            return 6;
        else if (gameField[0] != 2 && gameField[4] != 2 && gameField[8] != 2)
            return 7;
        else if (gameField[2] != 2 && gameField[4] != 2 && gameField[6] != 2)
            return 8;

        else return 50;
    }

    boolean isMoveSafe(int[] gameField, int move) {
        if (move == 0) {
            return ((gameField[1] != 2 && gameField[2] != 2) || (gameField[3] != 2 && gameField[6] != 2) || (gameField[4] != 2 && gameField[8] != 2));
        } else if (move == 1) {
            return  ((gameField[0] != 2 && gameField[2] != 2) || (gameField[4] != 2 && gameField[7] != 2));
        } else if (move == 2) {
            return  ((gameField[0] != 2 && gameField[1] != 2) || (gameField[5] != 2 && gameField[8] != 2) || (gameField[4] != 2 && gameField[6] != 2));
        } else if (move == 3) {
            return  ((gameField[0] != 2 && gameField[6] != 2) || (gameField[4] != 2 && gameField[5] != 2));
        } else if (move == 4) {
            return  ((gameField[1] != 2 && gameField[7] != 2) || (gameField[3] != 2 && gameField[5] != 2) || (gameField[0] != 2 && gameField[8] != 2) || (gameField[2] != 2 && gameField[6] != 2));
        } else if (move == 5) {
            return  ((gameField[2] != 2 && gameField[8] != 2) || (gameField[3] != 2 && gameField[4] != 2));
        } else if (move == 6) {
            return  ((gameField[0] != 2 && gameField[3] != 2) || (gameField[7] != 2 && gameField[8] != 2) || (gameField[4] != 2 && gameField[2] != 2));
        } else if (move == 7) {
            return  ((gameField[1] != 2 && gameField[4] != 2) || (gameField[6] != 2 && gameField[8] != 2));
        } else if (move == 8) {
            return  ((gameField[2] != 2 && gameField[5] != 2) || (gameField[6] != 2 && gameField[7] != 2) || (gameField[4] != 2 && gameField[0] != 2));
        }
        return false;
    }

    public int computerTurn(int[] gameField){
        int move, diff = 0;

        while(true){
            move = randomComputerMove(gameField);
            diff++;
            if(!isMoveSafe(gameField,move)){
                if(isMoveCorrect(65, 40)) {
                    gameField[move] = 1;
                    break;
                }
            }
            if(diff == 15) {
                return 100;
            }
        }
        return move;
    }

}
