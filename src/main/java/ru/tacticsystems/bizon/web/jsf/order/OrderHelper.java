/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.order;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import ru.tacticsystems.bizon.web.entities.Order;
import ru.tacticsystems.bizon.web.services.OrderService;

/**
 *
 * @author udgin
 */
@Named(value = "orderHelper")
@RequestScoped
public class OrderHelper {

    @EJB
    private OrderService orderService;
    
    

    /**
     * Creates a new instance of OrderHelper
     */
    public OrderHelper() {
    }
    
    public Order get(Long id) {
        return orderService.get(id);
    }
    
}
