package com.editdining.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_purchase_master")
@Getter
@Setter
public class PurchaseMasterEntity {
    @Id
    private int purchaseId;
    private int sellerId;
    private int progress;
}
