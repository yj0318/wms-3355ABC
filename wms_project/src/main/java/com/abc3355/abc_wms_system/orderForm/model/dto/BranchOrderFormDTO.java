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
    //private LocalDate orderDate; //주문 날짜
    private LocalDate orderDate;//현재 시간으로 불러오나요???



}
