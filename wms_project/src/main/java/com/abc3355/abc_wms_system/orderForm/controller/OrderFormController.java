package com.abc3355.abc_wms_system.orderForm.controller;

import com.abc3355.abc_wms_system.orderForm.model.dto.BranchOrderFormDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;

public class OrderFormController {
    private OrderFormService orderFormService = new OrderFormService();
    public void insertOrder(BranchOrderFormDTO branchOrderFormDTO) {

    int result = orderFormService.insertOrderFrom(branchOrderFormDTO);


    }
}
