package com.frames.tables;

import com.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class IncomingTableLoader extends SwingWorker<Void, MailBox> {

    private DefaultTableModel incomingTableModel;
    String login;

    public IncomingTableLoader(DefaultTableModel incomingTableModel, String login) {
        this.incomingTableModel = incomingTableModel;
        this.login = login;
    }

    @Override
    protected Void doInBackground() throws Exception {
        List<String> addr = new ArrayList<String>();
        addr.add(login);
        addr.add("inbox");
        Request request = new Request(RequestCriteria.GET_INBOX_LETTERS_LIST, addr);
        Response response = null;
        response = ServerConnect.connect(request);
        List<Object> objects = response.getObjList();
        for (Object obj : objects) {
            MailBox mailBox = (MailBox) obj;
            System.out.println(mailBox);
        }


        return null;
    }
}
