package com.abc3355.abc_wms_system.Product.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductUpdateReqDto {
    private int productNo;
    private String ProductName;
    private int productPrice;
    private String isExpire;
    private int colorNo;
    private int sizeNo;
    private int categoryNo;
    private int amount;
}
