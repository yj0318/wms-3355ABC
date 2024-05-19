package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventoryDTO;

import java.util.List;

public interface InvColorMapper {

    List<InventoryDTO> searchInvenByColor(String color);
}
