package com.db.service;

import com.MailBox;
import com.Response;
import com.db.managers.impl.LetterManagerImpl;
import com.db.model.Letter;
import org.apache.log4j.Logger;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Alex
 * Date: 26.02.13
 */
public class LetterService {

    private final static Logger LOG = Logger.getLogger(LetterService.class);
    public void storeLetter(List<Object> list) {

        MailBox mail = (MailBox) list.get(0);
        Letter letter = new Letter(mail);
        LetterManagerImpl.getInstance().storeLetter(letter);
        LOG.info("Message stored");
    }

    public Response getListLetters(String login, String folderName) {

        Response response = new Response(null, null, true);
        List<Letter> list = LetterManagerImpl.getInstance().getLettersByFolder(login + "mailbox.ru", folderName);
        //List<MailBox> mailBoxList = new ArrayList<MailBox>();
        List<Object> objectList = new ArrayList<Object>();
        if (!list.isEmpty() && list != null) {
            for (Letter letter : list) {
                objectList.add(letter.returnMailBox());
            }
        }
        response.setObjList(objectList);
        LOG.info("Response send");
        return response;
    }
}
