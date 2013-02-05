package com.def.first.com.def.unsinc;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 01.02.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class SimpleArray {

    private final int[] array;
    private int writeIndex = 0;
    private final static Random generator = new Random();

    public SimpleArray(int size) {

        array = new int[size];
    }

    public void add(int value) {

        int position = writeIndex;

        try {
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        array[position] = value;

        System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(), value, position);

        ++writeIndex;
        System.out.println("next write index" + writeIndex);


    }

    @Override
    public String toString() {

        return "\nContens of simpleArray\n" + Arrays.toString(array);
    }
}
