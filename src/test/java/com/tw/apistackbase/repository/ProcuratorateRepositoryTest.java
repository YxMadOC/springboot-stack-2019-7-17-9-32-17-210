package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.Procurator;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    void should_save_with_procurators_find_return_with_procurators() {
        Procurator procurator = new Procurator();
        procurator.setProcuratorName("A");
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("ZHA");
        procuratorate.setProcurators(Collections.singletonList(procurator));
        procuratorateRepository.save(procuratorate);

        Procuratorate fetched = procuratorateRepository.findAll().get(0);

        assertNotNull(fetched.getProcurators().get(0));
    }

    @Test
    void should_save_with_cases_find_return_with_cases() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("ZHA");
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseName("A");
        caseInfo.setCaseTime(123456789L);
        procuratorate.setCaseInfos(Collections.singletonList(caseInfo));
        procuratorateRepository.save(procuratorate);

        Procuratorate fetched = procuratorateRepository.findAll().get(0);

        assertNotNull(fetched.getCaseInfos().get(0));

    }

}