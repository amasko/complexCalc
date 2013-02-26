package com;

import java.io.Serializable;
import java.util.List;

public class Request implements Serializable {

    private RequestCriteria requestCriteria;
    private List<String> list;
    private List<Object> objList;

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

    public void setObjList(List<Object> objList) {
        this.objList = objList;
    }

    public List<Object> getObjList() {

        return objList;
    }

    @Override
    public String toString() {
        return requestCriteria.toString()+"I'm a request"+ " ;";
    }
}
