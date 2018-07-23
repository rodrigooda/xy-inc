package com.oda.services;

import java.util.List;

import com.oda.domain.Client;

/*
*
* @author rodrigooda
*/
public interface ClientService {

    List<Client> listAll();

    Client getById(Integer id);

    Client saveOrUpdate(Client client);

    void delete(Integer id);

}