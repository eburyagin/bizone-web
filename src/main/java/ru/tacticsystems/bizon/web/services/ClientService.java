/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.jpa.ClientFacade;

/**
 *
 * @author udgin
 */
@Stateless
public class ClientService {

    @EJB
    private ClientFacade clientFacade;

    public List<Client> list() {
        return clientFacade.findAll();
    }
    
    public Client get(Long id) {
        return clientFacade.find(id);
    }
    
    public Client get(String code) {
        return clientFacade.findByCode(code);
    }
    
    public List<Client> autoComplete(String str) {
        return clientFacade.searchByCodeAndName(str);
    }
    
    public Client put(Client client) {
        if (client == null) {
            return null;
        }
        if (client.getId() == null || client.getId().equals(0L)) {
            clientFacade.create(client);
        } else {
            clientFacade.edit(client);
        }
        return client;
    }
    
    
}
