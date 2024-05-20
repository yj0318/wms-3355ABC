package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventorySearchDTO;

import java.util.List;

public interface InvSearchMapper {

    List<InventorySearchDTO> showAllInventory(int user);

    List<InventorySearchDTO> searchInvenByColor(int user,String color);

    List<InventorySearchDTO> searchInventorySize(int user, int size);

    List<InventorySearchDTO> searchInventoryCategory(int user, String category);

    List<InventorySearchDTO> searchZeroInventory(int user);

    List<InventorySearchDTO> searchInventoryName(int user, String name);
}
