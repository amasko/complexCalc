package com.def.first.com.def.unsinc;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 01.02.13
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class ArrayWriter implements Runnable{

    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int value, SimpleArray simpleArray) {

        startValue = value;
        sharedSimpleArray = simpleArray;
    }

    @Override
    public void run() {

        for (int i = startValue; i < startValue + 3; i++) {
            sharedSimpleArray.add(i);
        }

    }
}
