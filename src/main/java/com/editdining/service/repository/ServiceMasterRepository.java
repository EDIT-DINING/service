package com.editdining.service.repository;

import com.editdining.service.dto.ServiceDto;
import com.editdining.service.entity.ServiceMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceMasterRepository extends JpaRepository<ServiceMasterEntity, Integer> {
}
