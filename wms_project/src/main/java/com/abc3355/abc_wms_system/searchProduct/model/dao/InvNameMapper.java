package com.abc3355.abc_wms_system.searchProduct.model.dao;

import java.util.List;

public interface InvNameMapper {
    List<InventoryDTO> searchInventoryName(String name);
}
