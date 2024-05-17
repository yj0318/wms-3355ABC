package com.abc3355.abc_wms_system.Product.model.dao;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryRecordResDto;
import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;

import java.util.List;

public interface InventoryMapperPP {

    int updateInventory(InventoryReqDto inventoryReqDto);

    List<InventoryRecordResDto> getReceivingRecord();
}
