/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.order;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.entities.Order;
import ru.tacticsystems.bizon.web.services.ClientService;
import ru.tacticsystems.bizon.web.services.OrderService;

/**
 *
 * @author udgin
 */
@Named(value = "addOrderController")
@ViewScoped
public class AddOrderController implements Serializable {

    @EJB
    private OrderService orderService;

    @EJB
    private ClientService clientService;

    private Client client;
    private Order order;
    
    private int currentPage = 0;
    
    /**
     * Creates a new instance of newOrderController
     */
    public AddOrderController() {
   }
    
    public List<Client> completeClient(String query) {
        return clientService.autoComplete(query);
    }
    
    public void onClientSelect(SelectEvent event) {
        Client c = (Client)event.getObject();
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Существующий клиент", "Сейчас можно изменить реквизиты клиента или просто продолжить"));
    }
    
    public void nullClient() {
        client = null;
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Выберите другого клиента", ""));
    }
    
    public void newClient() {
        client = new Client();
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Новый клиент", "Заполните все поля, помеченные звездочкой"));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
