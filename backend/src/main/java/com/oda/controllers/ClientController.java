package com.oda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oda.domain.Client;
import com.oda.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Client> listClients(){
        return clientService.listAll();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Client getClient(@PathVariable Integer id){
        return clientService.getById(id);
    }

	@RequestMapping(value = "/client", method = RequestMethod.POST, headers = "Accept=application/json")
	public Client saveClient(@RequestBody Client client) {
		return clientService.saveOrUpdate(client);
	}
 
	@RequestMapping(value = "/client", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Client updateClient(@RequestBody Client client) {
		return clientService.saveOrUpdate(client);
	}
    
	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteClient(@PathVariable("id") Integer id) {
		clientService.delete(id);
 	} 
 
}