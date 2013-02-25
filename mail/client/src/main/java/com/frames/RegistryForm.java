package com.frames;

import com.listeners.action.ApplyLoginActionListener;
import com.listeners.action.ApplyRegistryListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 24.02.13
 * Time: 0:43
 * To change this template use File | Settings | File Templates.
 */
public class RegistryForm extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField birthDateField;
    private JTextField phoneField;

    public RegistryForm() {
        super();
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.layoutInit();
        this.setTitle("Registration");
        //this.setSize(350, 180);
        this.setLocationRelativeTo(null);
        this.setVisible(Boolean.TRUE);
    }

    private void layoutInit() {

        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createTitledBorder("Create account"));
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

        //pass
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

        JLabel namelabel = new JLabel("Name:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(namelabel, constraints);
        loginPanel.add(namelabel);
        nameField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(nameField, constraints);
        loginPanel.add(nameField);

        JLabel surnameLabel = new JLabel("Surname:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(surnameLabel, constraints);
        loginPanel.add(surnameLabel);
        surnameField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(surnameField, constraints);
        loginPanel.add(surnameField);

        JLabel birthDateLabel = new JLabel("Birth date:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(birthDateLabel, constraints);
        loginPanel.add(birthDateLabel);
        birthDateField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(birthDateField, constraints);
        loginPanel.add(birthDateField);

        JLabel phoneLabel = new JLabel("Phone number:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(phoneLabel, constraints);
        loginPanel.add(phoneLabel);
        phoneField = new JTextField(25);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.weightx = 1.0D;
        layout.setConstraints(phoneField, constraints);
        loginPanel.add(phoneField);
        //buttons panel
        JPanel buttonsPanel = new JPanel();
        JButton connectButton = new JButton("Submit");
        connectButton.addActionListener(new ApplyRegistryListener(this));
        buttonsPanel.add(connectButton);

        buttonsPanel.add(connectButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose();
            }
        });
        buttonsPanel.add(cancelButton);

        // Add panels to display.
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(loginPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // Size dialog to components.
        pack();
    }

    public String getLoginValue() {
        return loginField.getText();
    }

    public String getPasswordValue() {
        return new String (passwordField.getPassword());
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getSurnameField() {
        return surnameField.getText();
    }

    public String getBirthDateField() {
        return birthDateField.getText();
    }

    public String getPhoneField() {
        return phoneField.getText();
    }
}