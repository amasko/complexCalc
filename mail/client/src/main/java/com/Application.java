package com;

import com.frames.LoginForm;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12.02.13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String args[]) throws IOException {

        new LoginForm();
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();


        List<String> list = new ArrayList<String>();
        list.add("zhozho");
        list.add("petrov");
        list.add("12/12/113");
        list.add("123456");
        list.add(str);
        list.add("popopo");
        list.add("11/11/11");

        Request request = new Request(RequestCriteria.CREATE_ACCOUNT, list);
        System.out.println(ServerConnect.connect(request));


        while (true) {
            System.out.println("Doing something useful...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    */
    }
}
