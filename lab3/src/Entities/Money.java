package Entities;

import Enums.Gender;

public class Money extends Substance {
    private String name;
    private int value;

    public Money(String name, int value){
        this.name = name;
        this.value = value;
    }
    public void setValue(int money) {
        this.value = money;
    }

    public int getValue() {
        return this.value;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String  getName() {
        return this.name;
    }
}
