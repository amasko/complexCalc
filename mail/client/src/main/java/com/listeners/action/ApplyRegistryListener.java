package com.listeners.action;

import com.Request;
import com.RequestCriteria;
import com.Response;
import com.ServerConnect;
import com.frames.RegistryForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25.02.13
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public class ApplyRegistryListener implements ActionListener {

    private RegistryForm regForm;

    public ApplyRegistryListener(RegistryForm regForm) {
        this.regForm = regForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Response response = null;
        if (regForm.getLoginValue().length() < 1
                || regForm.getPasswordValue().length() < 1
                || regForm.getNameField().length() < 1
                || regForm.getSurnameField().length() < 1
                || regForm.getPhoneField().length() < 1
                || regForm.getBirthDateField().length() < 1) {
            JOptionPane.showMessageDialog(regForm,
                    "You should fill all registry fields",
                    "Missing field content", JOptionPane.ERROR_MESSAGE);
        } else {
            List<String> list = new ArrayList<String>();
            list.add(regForm.getLoginValue());
            list.add(regForm.getPasswordValue());
            list.add(regForm.getNameField());
            list.add(regForm.getSurnameField());
            list.add(regForm.getPhoneField());
            list.add(regForm.getBirthDateField());

            Request request = new Request(RequestCriteria.CHECK_REGISRTY, list);
            try {
                response = ServerConnect.connect(request);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (response != null && response.getSuccess() == false) {
                JOptionPane.showMessageDialog(regForm,
                        "Choose another login as it corresponds to your future e-mail address and can't be used",
                        "Failed to create an account", JOptionPane.ERROR_MESSAGE);
            } else if (response != null && response.getSuccess() == true){
                System.out.println("created, " +response.getSuccess());
            }
        }

    }
}
