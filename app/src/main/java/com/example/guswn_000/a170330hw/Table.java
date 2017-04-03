package com.example.guswn_000.a170330hw;

import java.text.StringCharacterIterator;
import java.util.Date;

/**
 * Created by guswn_000 on 2017-03-30.
 */

public class Table
{
    String table[], name;
    int pasta, pizza , membership;
    long time,date;

    public Table(String t, int pas, int piz, int member)
    {
        name = t;
        pasta = pas;
        pizza = piz;
        membership = member;
        time = new Date().getTime();
        date = new Date().getDate();
    }
}
