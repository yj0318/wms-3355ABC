package com.abc3355.abc_wms_system.orderProcess.model.dto;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderUpdateReqDTO {

    private int orderNo;

    public OrderUpdateReqDTO(int orderNo) {
        this.orderNo = orderNo;
    }
}
