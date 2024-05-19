package com.abc3355.abc_wms_system.common.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderProductDTO {

    private int orderNo;
    private int userNO;
    private int orderPrice;
    private int orderStatus_no;
    private String orderDetail;
    private java.sql.Date orderDate;
}
