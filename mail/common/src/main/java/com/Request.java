package com;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13.02.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class Request implements Serializable {

    private RequestCriteria requestCriteria;
    private List<String> list;

    public Request(RequestCriteria requestCriteria, List<String> list) {
        this.requestCriteria = requestCriteria;
        this.list = list;
    }

    public RequestCriteria getRequestCriteria() {
        return requestCriteria;
    }

    public List<String> getList() {
        return list;
    }
    //test string representation
    @Override
    public String toString() {
        return requestCriteria.toString()+"I'm a request"+ " ;";
    }
}
