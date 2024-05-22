package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class InputOrderDTO {
    private int productNo;
    private String productName;
    private int productPrice;
    private String color;
    private int size;

    private int amount;
    private int orderNo;
}


