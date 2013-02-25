package com.frames.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25.02.13
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class IncomingTableLoader extends SwingWorker<Void, Void> {

    DefaultTableModel incomingTableModel;

    public IncomingTableLoader(DefaultTableModel incommingTableModel) {
        this.incomingTableModel = incommingTableModel;
    }

    @Override
    protected Void doInBackground() throws Exception {

        return null;
    }
}
