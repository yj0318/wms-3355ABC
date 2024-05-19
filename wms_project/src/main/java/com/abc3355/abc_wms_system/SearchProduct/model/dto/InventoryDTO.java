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

}
