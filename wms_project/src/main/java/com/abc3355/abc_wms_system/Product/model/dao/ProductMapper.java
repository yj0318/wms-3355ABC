package com.abc3355.abc_wms_system.Product.model.dao;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;

public interface ProductMapper {

    /**
     * 상품
     */
    int selectAll();

    int saveProduct(ProductSaveReqDto productSaveReqDto);

    int updateProduct(int productNo, ProductUpdateReqDto productUpdateReqDto);

    int deleteProduct(int productNo);





}
