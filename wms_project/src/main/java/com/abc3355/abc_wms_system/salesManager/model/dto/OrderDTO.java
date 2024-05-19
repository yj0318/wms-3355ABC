package com.abc3355.abc_wms_system.salesManager.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderNo;
    private java.sql.Date orderDate;
    private int userNo;
    private String userName;
    private int orderPrice;
    private String orderStatusName;
    private String orderDetail;
}
