package com.abc3355.abc_wms_system.Product.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryReqDto {
    private int productNo;
    private int whId;
    private int amount;

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public InventoryReqDto(int productNo, int whId, int amount) {
        this.productNo = productNo;
        this.whId = whId;
        this.amount = amount;
    }
}

