package com.abc3355.abc_wms_system.orderProcess.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderUpdateReqDTO {

    private int orderNo;
    private String action;
}
