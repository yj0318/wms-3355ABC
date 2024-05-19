package com.abc3355.abc_wms_system.searchProduct.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventoryDTO {
    private int inventoryNo;
    private int inventoryAmount;
    private int whId;
    private int productNo;
    private SearchProductDTO productDTO;
    private SearchColorDTO colorDTO;
    private SearchSizeDTO sizeDTO;
    private SearchCategoryDTO categoryDTO;
    private String productName;
    private int productPrice;
    private String isExpire;
    private int categoryNo;
    private String categoryName;
    private int colorNo;
    private String colorName;
    private int sizeNo;
    private int sizeMm;
}
