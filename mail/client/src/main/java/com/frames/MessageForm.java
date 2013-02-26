package com.frames;

import com.Application;
import com.listeners.action.ApplySendListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageForm extends JDialog {

    private JTextField fromTextField, toTextField;
    private JTextField subjectTextField;

    // Message content text area.
    private JTextArea contentTextArea;

    String to = "", subject = "", content = "";

    public MessageForm() throws HeadlessException{
        super(Application.appFrame, true);
        init();
    }

    private void init() {
        this.layoutInit();
        this.setTitle("Message");
        this.setSize(580, 400);
        this.setLocationRelativeTo(Application.appFrame);
        this.setVisible(Boolean.TRUE);
    }
    private void layoutInit() {

        // Setup fields panel.
        JPanel fieldsPanel = new JPanel();
        GridBagConstraints constraints;
        GridBagLayout layout = new GridBagLayout();
        fieldsPanel.setLayout(layout);
        JLabel fromLabel = new JLabel("From:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(fromLabel, constraints);
        fieldsPanel.add(fromLabel);
        fromTextField = new JTextField();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(fromTextField, constraints);
        fieldsPanel.add(fromTextField);

        JLabel toLabel = new JLabel("To:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(toLabel, constraints);
        fieldsPanel.add(toLabel);
        toTextField = new JTextField(to);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 0);
        constraints.weightx = 1.0D;
        layout.setConstraints(toTextField, constraints);
        fieldsPanel.add(toTextField);

        JLabel subjectLabel = new JLabel("Subject:");
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 0);
        layout.setConstraints(subjectLabel, constraints);
        fieldsPanel.add(subjectLabel);
        subjectTextField = new JTextField(subject);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 0);
        layout.setConstraints(subjectTextField, constraints);
        fieldsPanel.add(subjectTextField);

        // Setup content panel.
        JScrollPane contentPanel = new JScrollPane();
        contentTextArea = new JTextArea(content, 10, 50);
        contentPanel.setViewportView(contentTextArea);

        // Setup buttons panel.
        JPanel buttonsPanel = new JPanel();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ApplySendListener(this));
        buttonsPanel.add(sendButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
        buttonsPanel.add(cancelButton);

        // Add panels to display.
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(fieldsPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // Size dialog to components.
        pack();
    }

    public String getFromTextField() {
        return fromTextField.getText();
    }

    public String getToTextField() {
        return toTextField.getText();
    }

    public String getSubjectTextField() {
        return subjectTextField.getText();
    }

    public String getContentTextArea() {
        return contentTextArea.getText();
    }
}
