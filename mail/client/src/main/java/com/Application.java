package com;

import com.frames.DefaultFrame;
import com.frames.LoginForm;
import com.frames.RegistryForm;
import java.io.*;

public class Application {

    private static RegistryForm regFrame;
    private static DefaultFrame appFrame;

    public static void main(String args[]) throws IOException {

        //new LoginForm();
        initAppFrame();
    }

    public static void initAppFrame() {
        appFrame = new DefaultFrame();
    }

    public static void initRegFrame() {
        regFrame = new RegistryForm();
    }
}
