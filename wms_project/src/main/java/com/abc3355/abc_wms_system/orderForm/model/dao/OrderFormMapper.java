package com.abc3355.abc_wms_system.orderForm.model.dao;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.ProductInputDTO;

public interface OrderFormMapper {

    int getTotalOrderPrice(InsertNoAndAmountDTO input);
    int insertOrderProduct(InsertNoAndAmountDTO input);
    int insertOrderDetail(InsertNoAndAmountDTO input);
    int getLastOrderNo();

}
