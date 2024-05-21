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
    private String color;
    private int size;
    private int productAmount;
}


