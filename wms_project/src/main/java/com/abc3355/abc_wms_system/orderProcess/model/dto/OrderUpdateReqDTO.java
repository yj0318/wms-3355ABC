package com.abc3355.abc_wms_system.orderProcess.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderUpdateReqDTO {

    private int orderNo;
    private String orderDetail;

    public OrderUpdateReqDTO(int orderNo) {
        this.orderNo = orderNo;
    }
}
