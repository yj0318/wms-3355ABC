package com.abc3355.abc_wms_system.salesManager.model.dao;

import com.abc3355.abc_wms_system.salesManager.model.dto.*;
import com.abc3355.abc_wms_system.common.model.dto.OrderProductDTO;

import java.util.List;

public interface SaleManagerSqlMapper {


    List<BranchDTO> getAllBranch();

    List<OrderDTO> selectAllOrder();

    List<ProductDTO> getAllProduct();

    List<SelectProductSaleDTO> selectProductSale(int no);

    List<SelectBranchOrderDTO> selectByBranchAndDate(SelectBranchAndDateDTO selectDTO);
}
