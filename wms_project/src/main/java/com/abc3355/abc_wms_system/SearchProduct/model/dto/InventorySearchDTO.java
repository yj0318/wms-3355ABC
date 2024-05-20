package com.abc3355.abc_wms_system.searchProduct.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventorySearchDTO {

    private int inventoryNo;
    private int inventoryAmount;
    private int whId;
    private int productNo;
    private String productName;
    private int productPrice;
    private String isExpire;
    private int categoryNo;
    private String categoryName;
    private int colorNo;
    private String colorName;
    private int sizeNo;
    private int sizeMm;
    private int userNo;
    private String userId;
}
