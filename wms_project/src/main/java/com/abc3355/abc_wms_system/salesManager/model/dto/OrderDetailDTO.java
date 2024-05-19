package com.abc3355.abc_wms_system.salesManager.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDTO {
    private int OD_NO;
    private int OD_AMOUNT;
    private int PRODUCT_NO;
}
