package com.smartyr.adventofcode.y2025.day1;

public class Safe {
    private static final int MAX = 99;
    private static final int MIN = 0;
    private final boolean countRotations;
    private int fullRotations = 0;
    private int dialLocation = 50;
    private int zeroCount = 0;
    private int moveTotal = 0;

    public Safe() {
        this.countRotations = false;
    }

    public Safe(boolean countRotations) {
        this.countRotations = countRotations;
    }

    public void move(final String instructions) {
        moveTotal++;
        char direction = instructions.charAt(0);
        int instruction = Integer.parseInt(instructions.substring(1));
        int instructionCleaned = validateInput(instruction);
        if (instructionCleaned == 0) {
            checkZero();
            return;
        }
        if (direction == 'L') {
            this.moveLeft(instructionCleaned);
        } else {
            this.moveRight(instructionCleaned);
        }
        checkZero();
    }

    //If input is > 100 we need to divide % it.
    public int validateInput(final int input) {
        int fullTurns = input / 100;
        this.fullRotations += fullTurns;
        return input % 100;
    }

    //move left removes
    public void moveLeft(final int instruction) {
        int location = dialLocation;
        dialLocation -= instruction;
        //prevent counting 0 twice.
        if (location != 0 && dialLocation == MIN) {
            fullRotations++;
        }
        if (dialLocation < MIN) {
            //prevent counting 0 twice.
            if (location != 0) {
                fullRotations++;
            }
            dialLocation = dialLocation + (MAX + 1);
        }
    }

    //move right increases
    public void moveRight(final int instruction) {
        dialLocation += instruction;
        if (dialLocation > MAX) {
            fullRotations++;
            dialLocation = dialLocation - (MAX + 1);
        }
    }

    public void checkZero() {
        if (dialLocation == 0) {
            zeroCount++;
        }
    }

    public int getTotal() {
        return countRotations ? fullRotations : zeroCount;
    }

    public int getMoveTotal() {
        return moveTotal;
    }

    public int getDialLocation() {
        return dialLocation;
    }
}