package com.def.first;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 31.01.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class PrintTask implements Runnable{

    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();

    public PrintTask(String name) {
        taskName = name;
        sleepTime = generator.nextInt(5000);
    }



    @Override
    public void run() {

        try {
            System.out.printf("%s is going to sleep for %d milliseconds. \n ", taskName, sleepTime);
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {

            System.out.printf("%s %s\n", taskName, "terminated prematurely due to interruption");
        }

        System.out.printf("%s done sleeping\n", taskName);
    }
}
