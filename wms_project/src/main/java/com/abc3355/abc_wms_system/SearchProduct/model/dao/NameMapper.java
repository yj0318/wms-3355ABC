package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;

import java.util.List;

public interface NameMapper {
    List<SearchProductDTO> searchByName(String name);
}
