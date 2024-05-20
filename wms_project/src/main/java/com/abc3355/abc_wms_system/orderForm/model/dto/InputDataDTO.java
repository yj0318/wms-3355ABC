package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class InputDataDTO {
    private int productNo;
    private String productName;
    private String color;
    private String size;
    private int amount;
    private int orderNo;
    private String userNo;

    public InputDataDTO(String productName, String color, String size, int amount) {
        this.productName = productName;
        this.color = color;
        this.size = size;
        this.amount = amount;
    }
}


