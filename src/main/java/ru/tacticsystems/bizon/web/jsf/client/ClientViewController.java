/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.client;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.services.ClientService;

/**
 *
 * @author udgin
 */
@Named(value = "clientViewController")
@ViewScoped
public class ClientViewController implements Serializable {

    @EJB
    private ClientService clientService;

    
    
    private Client client;
    
    /**
     * Creates a new instance of ClientInfoViewController
     */
    public ClientViewController() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (this.client == null) {
            this.client = client;
        }
    }
    
    public void save() {
        if (this.client == null) return;
        Client c = clientService.put(client);
        if (c != null) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Успешно", "Информация о клиенте успешно сохранена в базе данных"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Во время сохранения произошла ошибка. Попробуйте позже или обратитесь к системному администратору."));
        }
    }

}
