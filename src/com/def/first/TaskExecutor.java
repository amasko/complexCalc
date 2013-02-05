package com.def.first;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 31.01.13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class TaskExecutor {

    public static void main(String args[]) {

        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor: ");

        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        threadExecutor.shutdown();
        
        System.out.println("Tasks started, main ends");

    }
}
