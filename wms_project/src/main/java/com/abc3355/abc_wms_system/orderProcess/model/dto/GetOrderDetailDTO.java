package com.abc3355.abc_wms_system.orderProcess.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class GetOrderDetailDTO {

    private int odNo;
    private int orderNo;
    private String productName;
    private int odAmount;

    @Override
    public String toString() {
        return "상제 주문 번호 : " + odNo +
                ", 주문 번호 : " + orderNo +
                ", 상품 이름 : '" + productName + '\'' +
                ", 주문 수량 : " + odAmount;
    }
}
