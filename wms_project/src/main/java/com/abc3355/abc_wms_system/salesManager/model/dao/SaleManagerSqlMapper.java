package com.abc3355.abc_wms_system.salesManager.model.dao;

import com.abc3355.abc_wms_system.salesManager.model.dto.BranchDTO;
import com.abc3355.abc_wms_system.common.model.dto.OrderProductDTO;
import com.abc3355.abc_wms_system.salesManager.model.dto.SelectBranchAndDateDTO;

import java.util.List;

public interface SaleManagerSqlMapper {

    List<OrderProductDTO> selectByBranchAndDate(SelectBranchAndDateDTO selectDTO);

    List<BranchDTO> getAllBranch();
}
