package com;

import com.db.service.ApplyAccountCreate;
import com.db.service.ApplyLoginCheck;
import com.db.service.LetterService;
import org.apache.log4j.Logger;

import java.util.List;

public class RequestHandler {
    private final static Logger LOG = Logger.getLogger(RequestHandler.class);
    private RequestCriteria criteria;
    private List<String> list;
    private List<Object> objList;
    public RequestHandler(Request request) {
        criteria = request.getRequestCriteria();
        list = request.getList();
        objList = request.getObjList();
    }

    public Response handleRequest() {

        switch (criteria) {
            case CREATE_ACCOUNT:
                (new ApplyAccountCreate(list)).accountCreate();

                break;

            case CHECK_LOGIN:
                return (new ApplyLoginCheck(list)).checkLogin();

            case  CHECK_REGISRTY:
                if (new ApplyLoginCheck(list).addressIsExist()) {
                    return new Response(null, null, false);
                }else{
                    (new ApplyAccountCreate(list)).accountCreate();
                    return new Response(null, null, true);
                }
            case SEND_LETTER:
                new LetterService().storeLetter(objList);
                return new Response(null, null, true);

            case GET_INBOX_LETTERS_LIST:
                return (new LetterService().getListLetters(list.get(0), list.get(1)));


        }

        return new Response(null,null,false);
    }
}
