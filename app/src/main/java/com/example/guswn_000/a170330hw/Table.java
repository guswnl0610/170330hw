package com.example.guswn_000.a170330hw;

import java.text.StringCharacterIterator;
import java.util.Date;

/**
 * Created by guswn_000 on 2017-03-30.
 */

public class Table
{
    String name, membership, date;
    int pasta, pizza;

    public Table(String t, int pas, int piz, String member, String d)
    {
        name = t;
        pasta = pas;
        pizza = piz;
        membership = member;
        date = d;
    }

    public String getMembership() {
        return membership;
    }

    public int getPasta() {
        return pasta;
    }

    public int getPizza() {
        return pizza;
    }

    public String getDate() {
        return date;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setPasta(int pasta) {
        this.pasta = pasta;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }
}
