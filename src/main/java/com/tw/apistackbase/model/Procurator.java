package com.tw.apistackbase.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Procurator {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String procuratorId;

    private String procuratorName;

    public String getProcuratorId() {
        return procuratorId;
    }

    public void setProcuratorId(String procuratorId) {
        this.procuratorId = procuratorId;
    }

    public String getProcuratorName() {
        return procuratorName;
    }

    public void setProcuratorName(String procuratorName) {
        this.procuratorName = procuratorName;
    }
}
