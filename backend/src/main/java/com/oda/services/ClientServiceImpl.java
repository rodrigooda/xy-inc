package com.oda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oda.domain.Client;
import com.oda.repositories.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
    private ClientRepository clientRepository;
    
    public ClientServiceImpl() {
    }

    public List<Client> listAll() {
        List<Client> Clients = new ArrayList<>();
        clientRepository.findAll().forEach(Clients::add); //fun with Java 8
        return Clients;
    }

    public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveOrUpdate(Client Client) {
        clientRepository.save(Client);
        return Client;
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);

    }
}
