package com.abc3355.abc_wms_system.orderForm.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BranchOrderFormDTO {

    private int productNo; // 상품번호 product
    private int orderAmount;  // 수량
    private LocalDate orderDate; //주문 날짜

}
