package com.abc3355.abc_wms_system.orderForm.model.dao;

import com.abc3355.abc_wms_system.orderForm.model.dto.InputNoAndAmountDTO;

public interface OrderFormMapper {

    int getTotalOrderPrice(InputNoAndAmountDTO input);
    int insertOrderByTotalPrice(int no);
    int insertOrderDetailAmount(InputNoAndAmountDTO input);
    int getLastOrderNo();
}
