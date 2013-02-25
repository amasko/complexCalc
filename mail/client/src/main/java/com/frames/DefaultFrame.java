package com.frames;

import com.frames.tables.IncomingTableLoader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultFrame extends JFrame {

    public DefaultFrame() throws HeadlessException {
        super();
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        this.menuInit();
        this.layoutInit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Mail-service");
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setVisible(Boolean.TRUE);

    }

    private void layoutInit() {

        Container contentPane = this.getContentPane();
        JTabbedPane root = new JTabbedPane();
        root.add("Incoming", createIncommingPanel());
        contentPane.add(root);

    }

    private JPanel createIncommingPanel() {
        JPanel teacherPanel = new JPanel();
        /* Data table */
        final DefaultTableModel incomingTableModel = new DefaultTableModel(new Object[0][0], new String[]{"from","theme","when"});
        final JTable teacherTable = new JTable(incomingTableModel);
        JScrollPane scrollPane = new JScrollPane(teacherTable);
        teacherTable.setFillsViewportHeight(true);
        teacherPanel.setLayout(new BorderLayout());
        teacherPanel.add(scrollPane, BorderLayout.CENTER);
        IncomingTableLoader teacherTableLoader = new IncomingTableLoader(incomingTableModel);
        teacherTableLoader.execute();
        return teacherPanel;
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


    private class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
