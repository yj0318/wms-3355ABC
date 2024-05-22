package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class InsertNoAndAmountDTO {
    private int userNo;
    private int productNo;
    private int amount;
    private int orderNo;
    private int totalOrderPrice;

    public InsertNoAndAmountDTO(int userNo, int productNo, int amount, int orderNo) {
        this.userNo = userNo;
        this.productNo = productNo;
        this.amount = amount;
        this.orderNo = orderNo;
    }
}
