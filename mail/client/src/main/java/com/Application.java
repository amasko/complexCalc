package com;

import com.frames.DefaultFrame;
import com.frames.LoginForm;
import com.frames.RegistryForm;
import java.io.*;

public class Application {

    private static RegistryForm regFrame;
    public static DefaultFrame appFrame;

    public static void main(String args[]) throws IOException {

       // new LoginForm();
       initAppFrame();
    }

    public static void initAppFrame() {
        appFrame = new DefaultFrame("user3");
    }

    public static void initRegFrame() {
        regFrame = new RegistryForm();
    }
}
