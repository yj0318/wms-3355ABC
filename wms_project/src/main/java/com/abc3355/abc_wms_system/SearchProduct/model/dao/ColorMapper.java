package com.abc3355.abc_wms_system.searchProduct.model.dao;

import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColorMapper {

    List<SearchProductDTO> searchProductByColor(@Param("color")int color);

}
