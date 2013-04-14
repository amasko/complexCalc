package com.exigen.task;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Alex
 * Date: 09.04.13
 */
public class Validator {

    public boolean validate(String line) {
        return  validateBounds(line) &&
                validateAcceptable(line) &&
                validateParentheses(line) &&
                validateIncorrectSequence(line);
    }

    private boolean validateBounds(String line) {
        return line.startsWith("(") && line.endsWith(")");
    }

    private boolean validateAcceptable(String line) {
        char[] defCharset = "0123456789+-/*()i".toCharArray();
        List<Character> defCharList = new ArrayList<Character>();
        for (char ch : defCharset)
            defCharList.add(ch);
        for (char ch : line.toCharArray()) {
            if (defCharList.indexOf(ch) < 0)
                return false;
        }
        return true;
    }

    private boolean validateIncorrectSequence(String line) {
        return
                        !line.contains("-+") &&
                        !line.contains("+-") &&
                        !line.contains("--") &&
                        !line.contains("++") &&
                        !line.contains("/+") &&
                        !line.contains("/-") &&
                        !line.contains("/*") &&
                        !line.contains("*/") &&
                        !line.contains("//") &&
                        !line.contains("**") &&
                        !line.contains("+)") &&
                        !line.contains("-)") &&
                        !line.contains("()") &&
                        !line.contains("+*") &&
                        !line.contains("+/") &&
                        !line.contains("-*") &&
                        !line.contains("-/") &&
                        !line.contains(")(");
    }

    private boolean validateParentheses(String line) {
        int check = 0;
        int right = 0;
        for (char ch : line.toCharArray()) {
            if (ch=='(')
                check++;
            if (ch == ')') {
                check--;
                right++;
            }
        }
        return check == 0 && right > 0;
    }
}
