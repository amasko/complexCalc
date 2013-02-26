package com.listeners.action;

import com.*;
import com.frames.MessageForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * User: Alex
 * Date: 26.02.13
 */
public class ApplySendListener implements ActionListener {

    private MessageForm messageForm;

    public ApplySendListener(MessageForm messageForm) {
        this.messageForm = messageForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Response response = null;
        if (messageForm.getFromTextField().trim().length() < 1
                || messageForm.getToTextField().trim().length() < 1
                || messageForm.getSubjectTextField().trim().length() < 1
                || messageForm.getContentTextArea().trim().length() < 1) {
            JOptionPane.showMessageDialog(messageForm,
                    "One or more fields is missing.",
                    "Missing Field(s)", JOptionPane.ERROR_MESSAGE);
        }else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm ' on' MMMM dd yyyy", Locale.ENGLISH);
            String dateAsString = simpleDateFormat.format(new Date());
            MailBox mailBox = new MailBox(null, dateAsString, messageForm.getSubjectTextField(),
                    messageForm.getContentTextArea(), messageForm.getFromTextField(),
                    messageForm.getToTextField());
            List<Object> mailList = new ArrayList<Object>();
            mailList.add(mailBox);
            Request request = (new Request(RequestCriteria.SEND_LETTER, null));
            request.setObjList(mailList);
            try {
                response = ServerConnect.connect(request);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (response != null && response.getSuccess()==true) {

                System.out.println("Ok");

            }

        }
    }
}
