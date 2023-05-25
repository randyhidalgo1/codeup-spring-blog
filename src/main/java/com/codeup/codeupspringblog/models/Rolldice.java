package com.codeup.codeupspringblog.models;

public class Rolldice {
    private int diceRoll;
    private int userGuess;
    private boolean isCorrect;
    private int matchCount;
    private int diceRolls;

    public Rolldice() {
    }

    public Rolldice(int diceRoll, int userGuess, boolean isCorrect) {
        this.diceRoll = diceRoll;
        this.userGuess = userGuess;
        this.isCorrect = isCorrect;
    }

    public int getDiceRoll() {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    public Rolldice(int diceRoll, int userGuess, boolean isCorrect, int matchCount, int diceRolls) {
        this.diceRoll = diceRoll;
        this.userGuess = userGuess;
        this.isCorrect = isCorrect;
        this.matchCount = matchCount;
        this.diceRolls = diceRolls;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getDiceRolls() {
        return diceRolls;
    }

    public void setDiceRolls(int diceRolls) {
        this.diceRolls = diceRolls;
    }
}
