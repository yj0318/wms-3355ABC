package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class InsertNoAndAmountDTO {
    private int no;
    private int amount;
    private int orderNo;
}
