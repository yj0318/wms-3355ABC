package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventorySearchDTO;

import java.util.List;

public interface InvSearchMapper {


    List<InventorySearchDTO> showAllInventory();

    List<InventorySearchDTO> searchInvenByColor(String color);

    List<InventorySearchDTO> searchInventorySize(int size);

    List<InventorySearchDTO> searchInventoryCategory(String category);

    List<InventorySearchDTO> searchZeroInventory();

    List<InventorySearchDTO> searchInventoryName(String name);

}
