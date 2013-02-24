package com.db.managers;

import com.db.model.Address;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 21.02.13
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public interface AddressManager {

    public void create(Address address);

    public Address checkAddress(String login, String password);


}
