package com;

import java.io.Serializable;

/**
 * User: Alex
 * Date: 26.02.13
 */
public class MailBox implements Serializable {

    private Long id = null;
    private String created = null;
    private String theme = null;
    private String body = null;
    private String from = null;
    private String to = null;

    public MailBox() {
    }

//    public MailBox(Long id, String from, String to, String theme, String body, String created) {
//
//    }

    public MailBox(Long id, String created, String theme, String body, String from, String to) {
        this.id = id;
        this.created = created;
        this.theme = theme;
        this.body = body;
        this.from = from;
        this.to = to;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getId() {

        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getTheme() {
        return theme;
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    @Override
    public String toString() {
        return id +"; "+from+" ;"+to+" ;";
    }
}
