package com.tw.apistackbase.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Procurator {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String procuratorId;

    @NotNull
    private String procuratorName;

}
