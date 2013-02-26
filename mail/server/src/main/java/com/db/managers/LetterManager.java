package com.db.managers;

import com.db.model.Letter;

import java.util.List;

/**
 * User: Alex
 * Date: 26.02.13
 */
public interface LetterManager {

    public void storeLetter(Letter letter);

    public List<Letter> getLettersByFolder(String accName, String folderName);
}
