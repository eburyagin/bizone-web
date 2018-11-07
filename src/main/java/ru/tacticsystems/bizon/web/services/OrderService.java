/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.tacticsystems.bizon.web.entities.Order;
import ru.tacticsystems.bizon.web.jpa.OrderFacade;

/**
 *
 * @author udgin
 */
@Stateless
public class OrderService {

    @EJB
    private OrderFacade orderFacade;

    public List<Order> list() {
        return orderFacade.findAll();
    }

    public Order get(Long id) {
        return orderFacade.find(id);
    }

    public Order put(Order order) {
        if (order == null) {
            return null;
        }
        if (order.getId() == null || order.getId().equals(0L)) {
            orderFacade.create(order);
        } else {
            orderFacade.edit(order);
        }
        return order;
    }

}
