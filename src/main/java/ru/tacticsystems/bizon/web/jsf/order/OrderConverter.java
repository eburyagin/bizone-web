/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ru.tacticsystems.bizon.web.entities.Order;

/**
 *
 * @author udgin
 */
@FacesConverter("orderConverter")
public class OrderConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        OrderHelper controller = (OrderHelper) fc.getApplication().getELResolver().
                getValue(fc.getELContext(), null, "orderHelper");
        return controller.get(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            Order c = (Order)object;
            return String.valueOf(c.getId());
        } else {
            return null;
        }
    }
}
