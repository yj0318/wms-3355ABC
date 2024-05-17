package com.abc3355.abc_wms_system.Product.model.dao;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryRecordResDto;
import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;

import java.util.List;

public interface InventoryMapperPP {

    /**
     * 재고
     */
    int getProductAmt(int productNo);
    int saveInventoryByNewProduct(ProductSaveReqDto productSaveReqDto);

    int updateInventory(InventoryReqDto inventoryReqDto);

    int deleteInventory(int productNo);



}
