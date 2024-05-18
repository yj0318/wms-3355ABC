package com.abc3355.abc_wms_system.orderProcess.model.dto;


import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderListResDTO {

    private int orderNo;
    private String userId;
    private String whName;
    private int orderPrice;
    private String orderStatusName;
    private LocalDateTime orderDate;

    @Override
    public String toString() {
        return "[ 주문번호 : " + orderNo +
                ", 아이디 : '" + userId + '\'' +
                ", 지점 : '" + whName + '\'' +
                ", 총액 : " + orderPrice +
                ", 주문 상태 : '" + orderStatusName + '\'' +
                ", 주문 날짜 : " + orderDate +
                " ]";
    }
}
