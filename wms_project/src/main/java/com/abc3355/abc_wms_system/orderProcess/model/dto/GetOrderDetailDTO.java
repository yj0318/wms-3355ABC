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
    private int productNo;
    private int odAmount;

    public GetOrderDetailDTO(int orderNo, int productNo, int odAmount) {
        this.orderNo = orderNo;
        this.productNo = productNo;
        this.odAmount = odAmount;
    }

    @Override
    public String toString() {
        return "상제 주문 번호 : " + odNo +
                ", 주문 번호 : " + orderNo +
                ", 상품 이름 : '" + productName + '\'' +
                ", 주문 수량 : " + odAmount;
    }
}
