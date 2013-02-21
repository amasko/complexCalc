package com;

import com.db.service.ApplyAccountCreate;

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
                (new ApplyAccountCreate(list)).actionPerformed();

                break;
        }

        return new Response();
    }
}
