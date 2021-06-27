package com.editdining.service.service;

import com.editdining.service.entity.PurchaseReviewEntity;
import com.editdining.service.repository.PurchaseReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final PurchaseReviewRepository reviewRepo;

    public Page<PurchaseReviewEntity> getList(int service_id, Pageable pageable) {
        return reviewRepo.findByServiceId(service_id, pageable);
    }
}
