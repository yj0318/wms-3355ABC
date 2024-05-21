package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.ProductSearchDTO;

import java.util.List;

public interface ProductSearchMapper {

    List<ProductSearchDTO> searchAllProduct();

    List<ProductSearchDTO> searchProductByColor(String colors);

    List<ProductSearchDTO> searchBySize(int size);

    List<ProductSearchDTO> searchByCategory(String category);

    List<ProductSearchDTO> searchZeroProduct();

    List<ProductSearchDTO> searchByName(String name);

}
