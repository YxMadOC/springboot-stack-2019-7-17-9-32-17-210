package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<CaseInfo, String> {

    List<CaseInfo> findAllByOrderByCaseTimeDesc();

    List<CaseInfo> findByCaseName(String caseName);

}
