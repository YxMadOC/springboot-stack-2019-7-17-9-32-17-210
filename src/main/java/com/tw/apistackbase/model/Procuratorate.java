package com.tw.apistackbase.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Procuratorate {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String procuratorateId;

    @NotNull
    @Column(unique = true, length = 50)
    private String procuratorateName;

    @OneToMany
    @JoinColumn(name = "procuratorateId")
    private List<Procurator> procurators;

}
