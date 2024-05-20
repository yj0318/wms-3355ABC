package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class InventoryConditionDTO {

    private String productName;
    private int productId;
    private int productPrice;
    private int ColorNo;
    private String ColorName;
    private int sizeNo;
    private int sizeMm;
    private int inventoryAmount;
    private int whId;
    private String isExpire;

}