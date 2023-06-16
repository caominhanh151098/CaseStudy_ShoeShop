package com.example.casestudy_shoeshop.model.enums;

public enum Status {
    Shopping(1),
    Ordered(2),
    Delivery(3),
    Complete(4);
    private int index;

    Status(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
