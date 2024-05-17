package com.abc3355.abc_wms_system.Product.model.dao;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryRecordResDto;
import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;

import java.util.List;

public interface StoreStatusMapper {

    /**
     * 창고 입고 기록
     */
    int saveRecordByNewProduct(ProductSaveReqDto productSaveReqDto);

    int saveRecordByUpdateInventory(InventoryReqDto inventoryReqDto);

    List<InventoryRecordResDto> getReceivingRecord();

    int deleteStoreStatus(int productNo);
}
