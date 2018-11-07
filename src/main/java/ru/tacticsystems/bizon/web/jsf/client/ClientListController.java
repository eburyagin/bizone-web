/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.services.ClientService;

/**
 *
 * @author udgin
 */
@Named(value = "clientListController")
@ViewScoped
public class ClientListController implements Serializable {

    @EJB
    private ClientService clientService;

    private List<Client> clientList;
    private List<Client> selectedClientList;
    private Client selectedClient;

    /**
     * Creates a new instance of ClientListController
     */
    public ClientListController() {
        selectedClientList = new ArrayList();
    }

    public List<Client> getClientList() {
        if (clientList == null) {
            clientList = clientService.list();
        }
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Client> getSelectedClientList() {
        return selectedClientList;
    }

    public void setSelectedClientList(List<Client> selectedClientList) {
        this.selectedClientList = selectedClientList;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

}
