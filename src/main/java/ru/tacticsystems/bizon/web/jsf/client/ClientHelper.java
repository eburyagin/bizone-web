/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.client;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.services.ClientService;

/**
 *
 * @author udgin
 */
@Named(value = "clientHelper")
@RequestScoped
public class ClientHelper {

    @EJB
    private ClientService clientService;
    
    
    /**
     * Creates a new instance of ClientController
     */
    public ClientHelper() {
    }
    
    public Client get(Long id) {
        return clientService.get(id);
    }
    
}
