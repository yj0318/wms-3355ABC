package com.abc3355.abc_wms_system.orderProcess.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetailResDTO {

    private int odNo;
    private int odAmount;
    private int orderNo;
    private int productNo;
}
