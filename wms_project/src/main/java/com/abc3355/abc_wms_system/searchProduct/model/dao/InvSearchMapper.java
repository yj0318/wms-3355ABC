package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventoryDTO;

import java.util.List;

public interface InvSearchMapper {

    List<InventoryDTO> showAllInventory();

    List<InventoryDTO> searchInvenByColor(String color);

    List<InventoryDTO> searchInventorySize(int size);

    List<InventoryDTO> searchInventoryCategory(String category);

    List<InventoryDTO> searchZeroInventory();

    List<InventoryDTO> searchInventoryName(String name);
}
