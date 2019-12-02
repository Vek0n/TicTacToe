package com.szymonkaczmarek.tictactoe;

import java.util.Random;

class GameClassic extends Game {

    private int[] gameField = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public int[] getGameField(){return gameField;}


    public void resetGame(){
        int[] gameField = getGameField();
        for(int i=0; i<9; i++){
            gameField[i]=2;
        }
    }

    private int randomSecondMove(int a, int b){
        int[] arr = {a,b};
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(2);
        return arr[index];
    }

    public boolean isDraw(int[] gameField){
        boolean boardFull = true;
        for(int i=0; i<9; i++){
            if(gameField[i]==2){
                boardFull = false;
            }
        }
        if(boardFull){
            if (gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1)
                return false;
            else if (gameField[3] == 1 && gameField[4] == 1 && gameField[5] == 1)
                return false;
            else if (gameField[6] == 1 && gameField[7] == 1 && gameField[8] == 1)
                return false;
            else if (gameField[0] == 1 && gameField[3] == 1 && gameField[6] == 1)
                return false;
            else if (gameField[1] == 1 && gameField[4] == 1 && gameField[7] == 1)
                return false;
            else if (gameField[2] == 1 && gameField[5] == 1 && gameField[8] == 1)
                return false;
            else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1)
                return false;
            else if (gameField[2] == 1 && gameField[4] == 1 && gameField[6] == 1)
                return false;
            else if (gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0)
                return false;
            else if (gameField[3] == 0 && gameField[4] == 0 && gameField[5] == 0)
                return false;
            else if (gameField[6] == 0 && gameField[7] == 0 && gameField[8] == 0)
                return false;
            else if (gameField[0] == 0 && gameField[3] == 0 && gameField[6] == 0)
                return false;
            else if (gameField[1] == 0 && gameField[4] == 0 && gameField[7] == 0)
                return false;
            else if (gameField[2] == 0 && gameField[5] == 0 && gameField[8] == 0)
                return false;
            else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0)
                return false;
            else if (gameField[2] == 0 && gameField[4] == 0 && gameField[6] == 0)
                return false;
            else return true;
        }
        return false;
    }

    public boolean didComputerWin(int[] gameField) {

        if (gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1)
            return true;
        else if (gameField[3] == 1 && gameField[4] == 1 && gameField[5] == 1)
            return true;
        else if (gameField[6] == 1 && gameField[7] == 1 && gameField[8] == 1)
            return true;
        else if (gameField[0] == 1 && gameField[3] == 1 && gameField[6] == 1)
            return true;
        else if (gameField[1] == 1 && gameField[4] == 1 && gameField[7] == 1)
            return true;
        else if (gameField[2] == 1 && gameField[5] == 1 && gameField[8] == 1)
            return true;
        else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1)
            return true;
        else if (gameField[2] == 1 && gameField[4] == 1 && gameField[6] == 1)
            return true;

        else return false;
    }

    boolean didPlayerWin(int[] gameField) {

        if (gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0)
            return true;
        else if (gameField[3] == 0 && gameField[4] == 0 && gameField[5] == 0)
            return true;
        else if (gameField[6] == 0 && gameField[7] == 0 && gameField[8] == 0)
            return true;
        else if (gameField[0] == 0 && gameField[3] == 0 && gameField[6] == 0)
            return true;
        else if (gameField[1] == 0 && gameField[4] == 0 && gameField[7] == 0)
            return true;
        else if (gameField[2] == 0 && gameField[5] == 0 && gameField[8] == 0)
            return true;
        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0)
            return true;
        else if (gameField[2] == 0 && gameField[4] == 0 && gameField[6] == 0)
            return true;
        else return false;
    }

    private int isDanger(int[] gameField) {
        if (gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 2)
            return 2;
        else if (gameField[1] == 0 && gameField[2] == 0 && gameField[0] == 2)
            return 0;
        else if (gameField[3] == 0 && gameField[4] == 0 && gameField[5] == 2)
            return 5;
        else if (gameField[4] == 0 && gameField[5] == 0 && gameField[3] == 2)
            return 3;
        else if (gameField[6] == 0 && gameField[7] == 0 && gameField[8] == 2)
            return 8;
        else if (gameField[7] == 0 && gameField[8] == 0 && gameField[6] == 2)
            return 6;
        else if (gameField[0] == 0 && gameField[3] == 0 && gameField[6] == 2)
            return 6;
        else if (gameField[3] == 0 && gameField[6] == 0 && gameField[0] == 2)
            return 0;
        else if (gameField[1] == 0 && gameField[4] == 0 && gameField[7] == 2)
            return 7;
        else if (gameField[4] == 0 && gameField[7] == 0 && gameField[1] == 2)
            return 1;
        else if (gameField[2] == 0 && gameField[5] == 0 && gameField[8] == 2)
            return 8;
        else if (gameField[5] == 0 && gameField[8] == 0 && gameField[2] == 2)
            return 2;
        else if (gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 2)
            return 8;
        else if (gameField[4] == 0 && gameField[8] == 0 && gameField[0] == 2)
            return 0;
        else if (gameField[2] == 0 && gameField[4] == 0 && gameField[6] == 2)
            return 6;
        else if (gameField[4] == 0 && gameField[6] == 0 && gameField[2] == 2)
            return 2;

        else if (gameField[0] == 0 && gameField[2] == 0 && gameField[1] == 2)
            return 1;
        else if (gameField[3] == 0 && gameField[5] == 0 && gameField[4] == 2)
            return 4;
        else if (gameField[6] == 0 && gameField[8] == 0 && gameField[7] == 2)
            return 7;
        else if (gameField[0] == 0 && gameField[6] == 0 && gameField[3] == 2)
            return 3;
        else if (gameField[1] == 0 && gameField[7] == 0 && gameField[4] == 2)
            return 4;
        else if (gameField[2] == 0 && gameField[8] == 0 && gameField[5] == 2)
            return 5;
        else if (gameField[0] == 0 && gameField[8] == 0 && gameField[4] == 2)
            return 4;
        else if (gameField[2] == 0 && gameField[6] == 0 && gameField[4] == 2)
            return 4;
        else return 20;
    }

    private int isPossibleToWin(int[] gameField) {
        if (gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 2)
            return 2;
        else if (gameField[1] == 1 && gameField[2] == 1 && gameField[0] == 2)
            return 0;
        else if (gameField[3] == 1 && gameField[4] == 1 && gameField[5] == 2)
            return 5;
        else if (gameField[4] == 1 && gameField[5] == 1 && gameField[3] == 2)
            return 3;
        else if (gameField[6] == 1 && gameField[7] == 1 && gameField[8] == 2)
            return 8;
        else if (gameField[7] == 1 && gameField[8] == 1 && gameField[6] == 2)
            return 6;
        else if (gameField[0] == 1 && gameField[3] == 1 && gameField[6] == 2)
            return 6;
        else if (gameField[3] == 1 && gameField[6] == 1 && gameField[0] == 2)
            return 0;
        else if (gameField[1] == 1 && gameField[4] == 1 && gameField[7] == 2)
            return 7;
        else if (gameField[4] == 1 && gameField[7] == 1 && gameField[1] == 2)
            return 1;
        else if (gameField[2] == 1 && gameField[5] == 1 && gameField[8] == 2)
            return 8;
        else if (gameField[5] == 1 && gameField[8] == 1 && gameField[2] == 2)
            return 2;
        else if (gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 2)
            return 8;
        else if (gameField[4] == 1 && gameField[8] == 1 && gameField[0] == 2)
            return 0;
        else if (gameField[2] == 1 && gameField[4] == 1 && gameField[6] == 2)
            return 6;
        else if (gameField[4] == 1 && gameField[6] == 1 && gameField[2] == 2)
            return 2;

        else if (gameField[0] == 1 && gameField[2] == 1 && gameField[1] == 2)
            return 1;
        else if (gameField[3] == 1 && gameField[5] == 1 && gameField[4] == 2)
            return 4;
        else if (gameField[6] == 1 && gameField[8] == 1 && gameField[7] == 2)
            return 7;
        else if (gameField[0] == 1 && gameField[6] == 1 && gameField[3] == 2)
            return 3;
        else if (gameField[1] == 1 && gameField[7] == 1 && gameField[4] == 2)
            return 4;
        else if (gameField[2] == 1 && gameField[8] == 1 && gameField[5] == 2)
            return 5;
        else if (gameField[0] == 1 && gameField[8] == 1 && gameField[4] == 2)
            return 4;
        else if (gameField[2] == 1 && gameField[6] == 1 && gameField[4] == 2)
            return 4;
        else return 50;

    }

    private int secondInRow(int[] gameField){
        if(gameField[0] == 1 && gameField[1] == 2 && gameField[2] == 2){
            return randomSecondMove(1,2);
        }else if(gameField[0] == 2 && gameField[1] == 1 && gameField[2] == 2){
            return randomSecondMove(0,2);
        }else if(gameField[0] == 2 && gameField[1] == 2 && gameField[2] == 1){
            return randomSecondMove(0,1);
        }

        else if(gameField[3] == 1 && gameField[4] == 2 && gameField[5] == 2){
            return randomSecondMove(4,5);
        }else if(gameField[3] == 2 && gameField[4] == 1 && gameField[5] == 2){
            return randomSecondMove(3,5);
        }else if(gameField[3] == 2 && gameField[4] == 2 && gameField[5] == 1){
            return randomSecondMove(3,4);
        }

        else if(gameField[6] == 1 && gameField[7] == 2 && gameField[8] == 2){
            return randomSecondMove(7,8);
        }else if(gameField[6] == 2 && gameField[7] == 1 && gameField[8] == 2){
            return randomSecondMove(6,8);
        }else if(gameField[6] == 2 && gameField[7] == 2 && gameField[8] == 1){
            return randomSecondMove(6,7);
        }

        else if(gameField[0] == 1 && gameField[3] == 2 && gameField[6] == 2){
            return randomSecondMove(3,6);
        }else if(gameField[0] == 2 && gameField[3] == 1 && gameField[6] == 2){
            return randomSecondMove(0,6);
        }else if(gameField[0] == 2 && gameField[3] == 2 && gameField[6] == 1){
            return randomSecondMove(0,3);
        }

        else if(gameField[1] == 1 && gameField[4] == 2 && gameField[7] == 2){
            return randomSecondMove(4,7);
        }else if(gameField[1] == 2 && gameField[4] == 1 && gameField[7] == 2){
            return randomSecondMove(1,7);
        }else if(gameField[1] == 2 && gameField[4] == 2 && gameField[7] == 1){
            return randomSecondMove(1,4);
        }

        else if(gameField[2] == 1 && gameField[5] == 2 && gameField[8] == 2){
            return randomSecondMove(5,8);
        }else if(gameField[2] == 2 && gameField[5] == 1 && gameField[8] == 2){
            return randomSecondMove(2,8);
        }else if(gameField[2] == 2 && gameField[5] == 2 && gameField[8] == 1){
            return randomSecondMove(2,5);
        }


        else if(gameField[0] == 1 && gameField[4] == 2 && gameField[8] == 2){
            return randomSecondMove(4,8);
        }else if(gameField[0] == 2 && gameField[4] == 1 && gameField[8] == 2){
            return randomSecondMove(0,8);
        }else if(gameField[0] == 2 && gameField[4] == 2 && gameField[8] == 1){
            return randomSecondMove(0,4);
        }

        else if(gameField[2] == 1 && gameField[4] == 2 && gameField[6] == 2){
            return randomSecondMove(4,6);
        }else if(gameField[2] == 2 && gameField[4] == 1 && gameField[6] == 2){
            return randomSecondMove(2,6);
        }else if(gameField[2] == 2 && gameField[4] == 2 && gameField[6] == 1){
            return randomSecondMove(2,4);
        }
        else return 50;
    }


    int computerWonDrawLine(int[] gameField){
        if(gameField[0] == 1 && gameField[1] == 1 && gameField[2] == 1){
            return 1;
        }else if(gameField[3] == 1 && gameField[4] == 1 && gameField[5] == 1){
            return 2;
        }else if(gameField[6] == 1 && gameField[7] == 1 && gameField[8] == 1){
            return 3;
        }else if (gameField[0] == 1 && gameField[3] == 1 && gameField[6] == 1){
            return 4;
        }else if (gameField[1] == 1 && gameField[4] == 1 && gameField[7] == 1){
            return 5;
        }else if (gameField[2] == 1 && gameField[5] == 1 && gameField[8] == 1){
            return 6;
        }else if(gameField[0] == 1 && gameField[4] == 1 && gameField[8] == 1){
            return 7;
        }else if(gameField[2] == 1 && gameField[4] == 1 && gameField[6] == 1){
            return 8;
        }
        else return 99;
    }

    int playerWonDrawLine(int[] gameField){
        if(gameField[0] == 0 && gameField[1] == 0 && gameField[2] == 0){
            return 1;
        }else if(gameField[3] == 0 && gameField[4] == 0 && gameField[5] == 0){
            return 2;
        }else if(gameField[6] == 0 && gameField[7] == 0 && gameField[8] == 0){
            return 3;
        }else if (gameField[0] == 0 && gameField[3] == 0 && gameField[6] == 0){
            return 4;
        }else if (gameField[1] == 0 && gameField[4] == 0 && gameField[7] == 0){
            return 5;
        }else if (gameField[2] == 0 && gameField[5] == 0 && gameField[8] == 0){
            return 6;
        }else if(gameField[0] == 0 && gameField[4] == 0 && gameField[8] == 0){
            return 7;
        }else if(gameField[2] == 0 && gameField[4] == 0 && gameField[6] == 0){
            return 8;
        }
        else return 99;
    }

    public int computerTurn(int[] gameField){
        int move;

        if(isPossibleToWin(gameField) == 50){
            if(isDanger(gameField) != 20){
                if(isMoveCorrect(40, 20)) {
                    move = isDanger(gameField);
                    gameField[move] = 1;
                    return move;
                }else{
                    move = randomComputerMove(gameField);
                    gameField[move] = 1;
                    return move;
                }
            }else{
                if(secondInRow(gameField) == 50){
                    move = randomComputerMove(gameField);
                    gameField[move] = 1;
                    return move;
                }else {
                    move = secondInRow(gameField);
                    gameField[move] = 1;
                    return move;
                }
            }
        }else{
            if(isMoveCorrect(40, 20)) {
                move = isPossibleToWin(gameField);
                gameField[move] = 1;
                return move;
            }else{
                move = randomComputerMove(gameField);
                gameField[move] = 1;
                return move;
            }
        }
    }
}