package com.editdining.service.repository;

import com.editdining.service.entity.PurchaseReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseReviewRepository extends JpaRepository<PurchaseReviewEntity, Integer> {
    Page<PurchaseReviewEntity> findByServiceId(int service_id, Pageable pageable);
}
