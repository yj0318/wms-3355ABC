package com.abc3355.abc_wms_system.searchProduct.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductSearchDTO {

    private int productNo;
    private String productName;
    private int productPrice;
    private String isExpire;
    private int colorNo;
    private int sizeNo;
    private int categoryNo;;
    private String categoryName;
    private String ColorName;
    private int sizeMm;
    private int inventoryAmount;
    private int whId;
    private int inventoryNo;

}
