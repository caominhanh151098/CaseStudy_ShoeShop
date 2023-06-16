package com.example.casestudy_shoeshop.model.enums;

public enum EPrice {
    FIRST_VALUE(1, 0, 1_000_000),
    SECOND_VALUE(2, 1_000_000, 2_000_000),
    THIRD_VALUE(3, 2_000_000, 3_000_000),
    FOUR_VALUE(4, 3_000_000, 4_000_000),
    FIVE_VALUE(5, 4_000_000, 5_000_000);
    final int value;
    final int begin;
    final int end;

    EPrice(int value, int begin, int end) {
        this.value = value;
        this.begin = begin;
        this.end = end;
    }

    public int getValue() {
        return value;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
