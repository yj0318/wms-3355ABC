package com.abc3355.abc_wms_system.orderProcess.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderDetailUpdateReqDTO {

    private int odNo;
    private int odAmount;
    private int productNo;
}
