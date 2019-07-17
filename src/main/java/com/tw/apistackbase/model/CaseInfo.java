package com.tw.apistackbase.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class CaseInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String caseId;

    @NotNull
    private String caseName;

    @NotNull
    private Long caseTime;

    @OneToOne
    @JoinColumn(name = "caseId")
    private CaseRecord caseRecord;
}
