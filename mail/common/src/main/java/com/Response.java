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
public class Response implements Serializable {

    private RequestCriteria requestCriteria;
    private List<String> list;
    private List<Object> objList;
    private Boolean success = false;

    public Response(RequestCriteria requestCriteria, List<String> list, Boolean success) {
        this.requestCriteria = requestCriteria;
        this.list = list;
        this.success = success;
    }

    public RequestCriteria getRequestCriteria() {
        return requestCriteria;
    }

    public List<String> getList() {
        return list;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setRequestCriteria(RequestCriteria requestCriteria) {
        this.requestCriteria = requestCriteria;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String toString() {
        return requestCriteria.toString() + "test ;";
    }

    public void setObjList(List<Object> objList) {
        this.objList = objList;
    }

    public List<Object> getObjList() {

        return objList;
    }
}
