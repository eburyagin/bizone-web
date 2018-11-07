/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.tacticsystems.bizon.web.entities.Order;

/**
 *
 * @author udgin
 */
@Stateless
public class OrderFacade extends AbstractFacade<Order> {

    @PersistenceContext(unitName = "bizon-web_war_1.0.0_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(Order.class);
    }
    
}
