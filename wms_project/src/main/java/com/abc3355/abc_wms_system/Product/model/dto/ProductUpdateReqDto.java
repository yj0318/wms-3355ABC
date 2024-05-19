package com.abc3355.abc_wms_system.Product.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductUpdateReqDto {
    private int productNo;
    private String productName;
    private int productPrice;
    private String isExpire;
    private int colorNo;
    private int sizeNo;
    private int categoryNo;

    public ProductUpdateReqDto(int productNo, String productName, int productPrice, String isExpire, int colorNo, int sizeNo, int categoryNo) {
        this.productNo = productNo;
        this.productName = productName;
        this.productPrice = productPrice;
        this.isExpire = isExpire;
        this.colorNo = colorNo;
        this.sizeNo = sizeNo;
        this.categoryNo = categoryNo;
    }

}
