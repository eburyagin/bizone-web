/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import ru.tacticsystems.bizon.web.entities.Client;
import ru.tacticsystems.bizon.web.entities.Client_;

/**
 *
 * @author udgin
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "bizon-web_war_1.0.0_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    public Client findByCode(String code) {
        Query q = getEntityManager()
                .createQuery("SELECT c FROM Client c WHERE LOWER(c.code) = :code")
                .setParameter("code", code.toLowerCase());

        try {
            Client result = ((Client) q.getSingleResult());
            return result;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Client> searchByCodeAndName(String str) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Client> p = cq.from(Client.class);
        Predicate w = cb.like(
                cb.lower(
                        cb.concat(
                            p.get(Client_.code), 
                            p.get(Client_.name))), 
                "%" + str.toLowerCase() + "%"
        );
        cq.where(w);
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(10);
        return q.getResultList();
    }
}


