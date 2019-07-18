package com.tw.apistackbase.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String procuratorateId;

    @Column(unique = true, length = 50)
    private String procuratorateName;

    @OneToMany
    @JoinColumn(name = "procuratorateId")
    private List<Procurator> procurators;

    public String getProcuratorateId() {
        return procuratorateId;
    }

    public void setProcuratorateId(String procuratorateId) {
        this.procuratorateId = procuratorateId;
    }

    public String getProcuratorateName() {
        return procuratorateName;
    }

    public void setProcuratorateName(String procuratorateName) {
        this.procuratorateName = procuratorateName;
    }

    public List<Procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<Procurator> procurators) {
        this.procurators = procurators;
    }
}
