package com.listeners.action;

import com.Request;
import com.RequestCriteria;
import com.Response;
import com.ServerConnect;
import com.frames.LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 24.02.13
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
public class ApplyLoginActionListener implements ActionListener {

    private LoginForm loginForm;

    public ApplyLoginActionListener(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        Response response = null;
        if (loginForm.getLoginValue().length() < 1
                || loginForm.getPasswordValue().length() < 1) {
            JOptionPane.showMessageDialog(loginForm,
                    "You should fill both fields",
                    "Missing login or password", JOptionPane.ERROR_MESSAGE);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(loginForm.getLoginValue());
            list.add(loginForm.getPasswordValue());

            Request request = new Request(RequestCriteria.CHECK_LOGIN, list);
            try {
                response = ServerConnect.connect(request);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (response != null && response.getSuccess()== false) {
                JOptionPane.showMessageDialog(loginForm,
                        "Incorrect login or password",
                        "Failed to log in", JOptionPane.ERROR_MESSAGE);
            } else {

                //TODO: log in to MAIN FORM
                System.out.println(response != null ? response.getSuccess() : null);

            }
        }
    }
}
