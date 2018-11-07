/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.order;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ru.tacticsystems.bizon.web.entities.Order;
import ru.tacticsystems.bizon.web.services.OrderService;

/**
 *
 * @author udgin
 */
@Named(value = "orderViewController")
@ViewScoped
public class OrderViewController implements Serializable {

    @EJB
    private OrderService orderService;

    private Order order;

    /**
     * Creates a new instance of OrderViewController
     */
    public OrderViewController() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        if (this.order == null) {
            this.order = order;
        }
    }

    public void save() {
        if (this.order == null) {
            return;
        }
        Order o = orderService.put(order);
        if (o != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Успешно", "Информация о заказе успешно сохранена в базе данных"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка", "Во время сохранения произошла ошибка. Попробуйте позже или обратитесь к системному администратору."));
        }

    }

}
