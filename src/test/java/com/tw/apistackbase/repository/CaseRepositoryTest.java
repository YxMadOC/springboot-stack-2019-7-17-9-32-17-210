package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

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

}