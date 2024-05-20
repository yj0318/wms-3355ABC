package com.abc3355.abc_wms_system.orderForm.model.dao;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;

public interface OrderFormMapper {

    int getTotalOrderPrice(InsertNoAndAmountDTO input);
    int insertOrderByTotalPrice(int no);
    int insertOrderDetailAmount(InsertNoAndAmountDTO input);
    int getLastOrderNo();
}
