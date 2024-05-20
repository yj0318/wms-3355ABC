package com.abc3355.abc_wms_system.salesManager.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SelectProductSaleDTO {
    private int productNo;
    private String productName;
    private int productPrice;
    private int amount;
    private int totalPrice;
}
