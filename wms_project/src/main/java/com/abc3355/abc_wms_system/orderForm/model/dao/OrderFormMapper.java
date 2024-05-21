package com.abc3355.abc_wms_system.orderForm.model.dao;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;

import java.util.List;

public interface OrderFormMapper {

    int getTotalOrderPrice(InsertNoAndAmountDTO input);
    int insertOrderProduct(InsertNoAndAmountDTO input);
    int insertOrderDetail(InsertNoAndAmountDTO input);
    int getLastOrderNo();
    List<InventoryConditionDTO> inventoryOrderForm(String name);
    int getProductNo(InputOrderDTO input);

    int getMaxAmount(InputOrderDTO input);

    String printInvByProductNameOnly(String name);
}
