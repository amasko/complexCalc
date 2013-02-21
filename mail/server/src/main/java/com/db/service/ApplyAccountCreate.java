package com.db.service;

import com.db.managers.impl.AddressManagerImpl;
import com.db.managers.impl.UserManagerImpl;
import com.db.model.Address;
import com.db.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 21.02.13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class ApplyAccountCreate {

    private List<String> list;

    public ApplyAccountCreate(List<String> list) {
        this.list = list;
    }

    public void actionPerformed() {

        User user = new User();
        Address address = new Address();
        //user.setAddress(login+"dfg");
        String name = list.get(0);
        String surname = list.get(1);
        String birthDate = list.get(2);
        String phone = list.get(3);
        String login = list.get(4);
        String pass = list.get(5);
        String creation = list.get(6);
        user.setPassword(pass);
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setBirthDate(birthDate);

        address.setAddr(login + "@mailbox.ru");
        address.setUser(user);
        address.setCreationDate(creation);
        UserManagerImpl.getInstance().create(user);
        AddressManagerImpl.getInstance().create(address);
    }

}
