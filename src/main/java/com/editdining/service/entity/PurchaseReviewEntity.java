package com.editdining.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_purchase_review")
@Getter
@Setter
public class PurchaseReviewEntity {
    @Id
    private int purchaseId;
    private double rate;
    private String review;
    private String reply;
    private int serviceId;
}
