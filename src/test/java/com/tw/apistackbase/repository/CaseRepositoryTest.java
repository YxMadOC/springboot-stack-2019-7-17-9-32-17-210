package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.CaseRecord;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    void should_find_all_cases_order_by_time_desc() {
        CaseInfo caseInfo1 = new CaseInfo();
        caseInfo1.setCaseName("A");
        caseInfo1.setCaseTime(123456789L);
        CaseInfo caseInfo2 = new CaseInfo();
        caseInfo2.setCaseName("B");
        caseInfo2.setCaseTime(133456789L);
        caseRepository.saveAndFlush(caseInfo1);
        caseRepository.saveAndFlush(caseInfo2);

        List<CaseInfo> fetchedCases = caseRepository.findAllByOrderByCaseTimeDesc();

        assertEquals("B", fetchedCases.get(0).getCaseName());
        assertEquals("A", fetchedCases.get(1).getCaseName());
    }

    @Test
    void should_find_case_by_name() {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseName("A");
        caseInfo.setCaseTime(123456789L);
        caseRepository.saveAndFlush(caseInfo);

        CaseInfo fetched = caseRepository.findByCaseName("A");

        assertEquals("A", fetched.getCaseName());
    }

    @Test
    void should_save_with_case_record_find_return_with_case_record() {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseName("A");
        caseInfo.setCaseTime(123456789L);
        CaseRecord caseRecord = new CaseRecord();
        caseRecord.setObjectiveDescription("AAA");
        caseRecord.setSubjectiveDescription("BBB");
        caseInfo.setCaseRecord(caseRecord);
        caseRepository.saveAndFlush(caseInfo);

        CaseInfo fetched = caseRepository.findByCaseName("A");

        assertNotNull(fetched.getCaseRecord());
    }

    @Test
    void should_return_case_with_procuratorate_if_case_has() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("ZHA");
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseName("A");
        caseInfo.setCaseTime(123456789L);
        caseInfo.setProcuratorate(procuratorate);
        procuratorate.setCaseInfos(Collections.singletonList(caseInfo));
        procuratorateRepository.save(procuratorate);

        CaseInfo fetched = caseRepository.findByCaseName("A");

        assertNotNull(fetched.getProcuratorate());
    }

}