/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.order;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import ru.tacticsystems.bizon.web.entities.Order;
import ru.tacticsystems.bizon.web.services.OrderService;

/**
 *
 * @author udgin
 */
@Named(value = "orderListController")
@ViewScoped
public class OrderListController implements Serializable {

    @EJB
    private OrderService orderService;

    private List<Order> orderList;
    private List<Order> selectedOrderList;
    private Order selectedOrder;

    /**
     * Creates a new instance of OrderListController
     */
    public OrderListController() {
        selectedOrderList = new ArrayList();
   }

    public List<Order> getOrderList() {
        if (orderList == null) {
            orderList = orderService.list();
        }
        return orderList;
    }

    public List<Order> getSelectedOrderList() {
        return selectedOrderList;
    }

    public void setSelectedOrderList(List<Order> selectedOrderList) {
        this.selectedOrderList = selectedOrderList;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

}
