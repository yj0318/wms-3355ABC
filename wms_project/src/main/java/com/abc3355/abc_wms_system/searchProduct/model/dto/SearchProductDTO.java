package com.abc3355.abc_wms_system.searchProduct.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchProductDTO {
    private int productNo;
    private String productName;
    private int productPrice;
    private String isExpire;
    private int colorNo;
    private int sizeNo;
    private int categoryNo;
    private SearchCategoryDTO categoryDTO;
    private SearchColorDTO colorDTO;
}
