package com.editdining.service.dto;

import com.editdining.service.entity.PurchaseReviewEntity;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDto {
    private int purchaseId;
    private double rate;
    private String review;
    private String reply;
    private int serviceId;

    public ReviewDto(PurchaseReviewEntity entity) {
        this.purchaseId = entity.getPurchaseId();
        this.rate = entity.getRate();
        this.review = entity.getReview();
        this.reply = entity.getReply();
        this.serviceId = entity.getServiceId();
    }
}
