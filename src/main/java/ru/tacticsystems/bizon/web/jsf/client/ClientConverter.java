/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.client;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ru.tacticsystems.bizon.web.entities.Client;

/**
 *
 * @author udgin
 */
@FacesConverter("clientConverter")
public class ClientConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        ClientHelper controller = (ClientHelper) fc.getApplication().getELResolver().
                getValue(fc.getELContext(), null, "clientHelper");
        return controller.get(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            Client c = (Client)object;
            return String.valueOf(c.getId());
        } else {
            return null;
        }
    }
}
