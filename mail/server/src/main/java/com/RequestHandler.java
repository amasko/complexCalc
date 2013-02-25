package com;

import com.db.service.ApplyAccountCreate;
import com.db.service.ApplyLoginCheck;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 21.02.13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class RequestHandler {

    private RequestCriteria criteria;
    private List<String> list;

    public RequestHandler(Request request) {
        criteria = request.getRequestCriteria();
        list = request.getList();
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
        }

        return new Response(null,null,false);
    }
}
