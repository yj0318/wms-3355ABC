package com.abc3355.abc_wms_system.Product.model.dao;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    /**
     * 상품
     */
    int selectAll();

    int saveProduct(ProductSaveReqDto productSaveReqDto);

    int updateProduct(ProductUpdateReqDto productUpdateReqDto);

    int deleteProduct(int productNo);





}
