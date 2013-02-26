package com.frames;

import com.frames.tables.IncomingTableLoader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultFrame extends JFrame {

    private String appLofin;
    public DefaultFrame(String login) throws HeadlessException {
        super();
        appLofin = login;
        init();
    }

    private void init() {
        this.menuInit();
        this.mailButtonPanel();
        this.layoutInit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Mail-service");
        this.setSize(640, 480);
    }

    private void layoutInit() {

        Container contentPane = this.getContentPane();
        JTabbedPane root = new JTabbedPane();
        root.add("Incoming", createPanel("inbox"));
//        root.add("Outgoing", createPanel("outbox"));
//        root.add("Recycler", createPanel("recycle"));
        //
        contentPane.add(root);
    }

    private MailPanel createPanel(String type) {
        MailPanel panel = new MailPanel(type);
        /* Data table */
        final DefaultTableModel incomingTableModel = new DefaultTableModel(new Object[0][0], new String[]{"from","theme","when"});
        final JTable incomingTable = new JTable(incomingTableModel);
        JScrollPane scrollPane = new JScrollPane(incomingTable);
        incomingTable.setFillsViewportHeight(true);
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        IncomingTableLoader incomingTableLoader = new IncomingTableLoader(incomingTableModel, appLofin);
        incomingTableLoader.execute();
        return panel;
    }

    private void menuInit() {
        JMenuBar menuBar = new JMenuBar();
        /* File menu */
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitFileMenu = new JMenuItem("Exit");
        exitFileMenu.addActionListener(new ExitActionListener());
        fileMenu.add(exitFileMenu);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    private void mailButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton newButton = new JButton("New Message");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MessageForm();
            }
        });
        buttonPanel.add(newButton);
        this.setLocationRelativeTo(null);
        this.setVisible(Boolean.TRUE);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);


    }

    private class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
