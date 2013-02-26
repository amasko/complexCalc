package com.db.service;

import com.Response;
import com.db.managers.impl.AddressManagerImpl;
import com.db.model.Address;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 24.02.13
 * Time: 1:51
 * To change this template use File | Settings | File Templates.
 */
public class ApplyLoginCheck {

    private List<String> list;

    public ApplyLoginCheck(List<String> list) {
        this.list = list;
    }

    public Response checkLogin() {

        String login = list.get(0);
        String pass = list.get(1);

        Address address = AddressManagerImpl.getInstance().checkAddress(login, pass);
        return (address == null) ? (new Response(null, null, false)) : new Response(null, null, true);

    }

    public boolean addressIsExist() {
        String login = list.get(0);
        return AddressManagerImpl.getInstance().checkExist(login);
    }
}
