package com.frames;

import com.Application;
import com.listeners.action.ApplyLoginActionListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 23.02.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends JFrame{

    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginForm() {
        super();
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.layoutInit();
        this.setTitle("Login");
        //this.setSize(350, 180);
        this.setLocationRelativeTo(null);
        this.setVisible(Boolean.TRUE);
    }

    private void layoutInit() {

        // Setup settings panel.
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createTitledBorder("Connection"));
        GridBagConstraints constraints;
        GridBagLayout layout = new GridBagLayout();
        loginPanel.setLayout(layout);

        JLabel loginLabel = new JLabel("Login:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(loginLabel, constraints);
        loginPanel.add(loginLabel);
        loginField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(loginField, constraints);
        loginPanel.add(loginField);

        JLabel passwordLabel = new JLabel("Password:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 5, 0);
        layout.setConstraints(passwordLabel, constraints);
        loginPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(passwordField, constraints);
        loginPanel.add(passwordField);

        // Setup buttons panel.
        JPanel buttonsPanel = new JPanel();

        JButton connectButton = new JButton("Submit");
        connectButton.addActionListener(new ApplyLoginActionListener(this));
        buttonsPanel.add(connectButton);

        buttonsPanel.add(connectButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionCancel();
            }
        });
        buttonsPanel.add(cancelButton);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.initRegFrame();
                dispose();
            }
        });
        buttonsPanel.add(createButton);

        // Add panels to display.
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(loginPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // Size dialog to components.
        pack();
    }

    // Cancel connecting and exit program.
    private void actionCancel() {
        System.exit(0);
    }

    public String getLoginValue() {
        return loginField.getText();
    }

    public String getPasswordValue() {
        return new String (passwordField.getPassword());
    }
}
