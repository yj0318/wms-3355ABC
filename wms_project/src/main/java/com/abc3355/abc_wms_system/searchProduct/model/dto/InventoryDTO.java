package com.abc3355.abc_wms_system.searchProduct.model.dto;

import lombok.*;

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
}
