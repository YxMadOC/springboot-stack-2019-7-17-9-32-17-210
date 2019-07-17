package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRecordRepository extends JpaRepository<CaseRecord, String> {
}
