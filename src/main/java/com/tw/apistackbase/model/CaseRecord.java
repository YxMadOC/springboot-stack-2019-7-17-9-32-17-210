package com.tw.apistackbase.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CaseRecord {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(strategy = "uuid", name = "uuid")
    private String caseRecordId;

    private String subjectiveDescription;

    private String objectiveDescription;

    public String getCaseRecordId() {
        return caseRecordId;
    }

    public void setCaseRecordId(String caseRecordId) {
        this.caseRecordId = caseRecordId;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }
}
