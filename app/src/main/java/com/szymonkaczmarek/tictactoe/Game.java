package com.szymonkaczmarek.tictactoe;

import java.util.Random;

public abstract class Game {

    protected int difficultyLevelGame;

    abstract public int[] getGameField();

    public int getDifficultyLevelGame() {return difficultyLevelGame;}

    public void setDifficultyLevelGame(){
        difficultyLevelGame = ChooseGameTypeActivity.difficultyLevel;
    }

    public boolean isFieldEmpty(int[] gameField, int move) {
        return (gameField[move] == 2);
    }

    public int randomComputerMove(int[] gameField) {
        Random randomGenerator = new Random();
        int move = randomGenerator.nextInt(9);
        while (true) {
            if (isFieldEmpty(gameField, move)) {
                break;
            } else {
                move = randomGenerator.nextInt(9);
            }
        }
        return move;
    }

    public int difficultyRandomNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100);
    }

    public boolean isMoveCorrect(int hard, int easy){
        setDifficultyLevelGame();
        int diffLvl = difficultyRandomNumber();

        if(getDifficultyLevelGame() == 1){
            return diffLvl > hard;
        }
        else if (getDifficultyLevelGame() == 2){
            return diffLvl > easy;
        }
        else return true;
    }

    public void playerTurn (int move){
        int[] gameField = getGameField();
        gameField[move] = 0;
    }

    public void playerTwoTurn(int move){
        int[] gameField = getGameField();
        gameField[move] = 1;
    }

    abstract void resetGame();
    abstract int computerTurn(int[] gameField);

}
