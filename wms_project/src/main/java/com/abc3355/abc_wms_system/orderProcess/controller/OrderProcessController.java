package com.abc3355.abc_wms_system.orderProcess.controller;

import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.service.OrderProcessService;
import com.abc3355.abc_wms_system.orderProcess.view.ResultView;

import java.util.List;

public class OrderProcessController {


    public void searchAllOrders() {
        List<OrderListResDTO> orderList = OrderProcessService.searchAllOrders();
        ResultView.dislplayOrderList(orderList);
    }
    public void searchOrdersByName(String name) {
        List<OrderListResDTO> orderList = OrderProcessService.searchOrdersByName(name);
        ResultView.dislplayOrderList(orderList);
    }
    public void searchOrdersByStatus(String status) {
        List<OrderListResDTO> orderList = OrderProcessService.searchOrdersByStatus(status);
        ResultView.dislplayOrderList(orderList);
    }
}
