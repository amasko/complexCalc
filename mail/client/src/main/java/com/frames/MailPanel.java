package com.frames;

import javax.swing.*;

/**
 * User: Alex
 * Date: 25.02.13
 */
public class MailPanel extends JPanel {

    private String type;

    public MailPanel(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
