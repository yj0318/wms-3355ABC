package com.abc3355.abc_wms_system.searchProduct.model.dao;

import java.util.List;

public interface InvDetailMapper {

    List<InventoryDTO> searchInventorySize(int size);

    List<InventoryDTO> searchInventoryCategory(String category);
}
