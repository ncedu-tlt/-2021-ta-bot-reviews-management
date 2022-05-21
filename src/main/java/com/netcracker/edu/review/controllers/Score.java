package com.netcracker.edu.review.controllers;

public enum Score {
    excellent(5),
    good(4),
    normal(3),
    bad(2),
    veryBad(1);

    private final int valueScore;

    Score(int valueScore) {
        this.valueScore = valueScore;
    }

    public int getValueScore() {
        return valueScore;
    }
}
