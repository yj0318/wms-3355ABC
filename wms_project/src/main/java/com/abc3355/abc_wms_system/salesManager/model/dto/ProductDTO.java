package com.abc3355.abc_wms_system.salesManager.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private int productNo;
    private String productName;
    private int productPrice;
    private String isExpire;
    private String colorName;
    private String sizeName;
    private String categoryName;
}
