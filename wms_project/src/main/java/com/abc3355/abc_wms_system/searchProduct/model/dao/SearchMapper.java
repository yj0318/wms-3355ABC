package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;

import java.util.List;
import java.util.Map;

public interface SearchMapper {

    List<SearchProductDTO> searchAllProduct();

    List<SearchProductDTO> searchByCategory(String category);
}
