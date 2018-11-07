/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.jsf;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import ru.tacticsystems.bizon.web.bpm.BpmService;

/**
 *
 * @author udgin
 */
@Named(value = "dashboardController")
@ViewScoped
public class DashboardController implements Serializable {

    @EJB
    private BpmService bpmService;

    private DashboardModel model;

    /**
     * Creates a new instance of DachboardController
     */
    public DashboardController() {
    }

    public String getProcessCount() {
        return bpmService.getProcess();
    }

}
