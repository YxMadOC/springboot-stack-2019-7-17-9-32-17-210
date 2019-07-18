package com.tw.apistackbase.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class CaseInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String caseId;

    private String caseName;

    private Long caseTime;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "caseRecordId")
    private CaseRecord caseRecord;

    @ManyToOne
    @JoinColumn(name = "procuratorateId")
    private Procuratorate procuratorate;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(Long caseTime) {
        this.caseTime = caseTime;
    }

    public CaseRecord getCaseRecord() {
        return caseRecord;
    }

    public void setCaseRecord(CaseRecord caseRecord) {
        this.caseRecord = caseRecord;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
