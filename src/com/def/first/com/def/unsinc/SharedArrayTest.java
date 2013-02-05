package com.def.first.com.def.unsinc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 01.02.13
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class SharedArrayTest {

    public static void main(String args[]) {

        SimpleArray sharedSimpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);
        System.out.println();

        executorService.shutdown();


        try {
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (taskEnded) {
                System.out.println(sharedSimpleArray);
            }
            else
                System.out.println("Timed out while waiting for task to finish");

        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for task to finish");
        }
    }
}
