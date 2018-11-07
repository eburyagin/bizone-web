/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tacticsystems.bizon.web.bpm;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author udgin
 */
@Startup
@Singleton
public class BpmService implements Serializable {

    private ProcessEngine processEngine;

    @PostConstruct
    public void init() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:postgresql://localhost:5432/activiti")
                .setJdbcUsername("postgres")
                .setJdbcPassword("1qaz@WSX")
                .setJdbcDriver("org.postgresql.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

//        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//                .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
//                .setJdbcUsername("sa")
//                .setJdbcPassword("")
//                .setJdbcDriver("org.h2.Driver")
//                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        
        processEngine = cfg.buildProcessEngine();

    }

    @PreDestroy
    public void finish() {
        Logger.getLogger(this.getClass()).info("ProcessEngine stoping...");
    }

    public String getProcess() {
        String pName = processEngine.getName();
        String ver = ProcessEngine.VERSION;
        Logger.getLogger(this.getClass()).info("ProcessEngine [" + pName + "] Version: [" + ver + "]");
        return "ProcessEngine [" + pName + "] Version: [" + ver + "]";
    }

}
