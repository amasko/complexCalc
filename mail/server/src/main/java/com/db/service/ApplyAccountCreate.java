package com.db.service;

import com.db.managers.impl.AddressManagerImpl;
import com.db.managers.impl.UserManagerImpl;
import com.db.model.Address;
import com.db.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ApplyAccountCreate {

    private List<String> list;

    public ApplyAccountCreate(List<String> list) {
        this.list = list;
    }

    public void accountCreate() {

        User user = new User();
        Address address = new Address();

        String login = list.get(0);
        String pass = list.get(1);
        String name = list.get(2);
        String surname = list.get(3);
        String phone = list.get(4);
        String birthDate = list.get(5);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm ' on' MMMM dd yyyy");
        String dateAsString = simpleDateFormat.format(new Date());

        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setBirthDate(birthDate);

        address.setAddr(login + "@mailbox.ru");
        address.setPassword(pass);
        address.setCreationDate(dateAsString);
        address.setUser(user);

        UserManagerImpl.getInstance().create(user);
        AddressManagerImpl.getInstance().create(address);
    }

}
