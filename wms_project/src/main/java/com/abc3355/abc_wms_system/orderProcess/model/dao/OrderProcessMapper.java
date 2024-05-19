package com.abc3355.abc_wms_system.orderProcess.model.dao;

import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderDetailResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;

import java.util.List;
import java.util.Map;

public interface OrderProcessMapper {
    List<OrderListResDTO> selectAllOrders();
    List<OrderListResDTO> selectOrdersByName(String name);
    List<OrderListResDTO> selectOrdersByStatus(String status);
    List<OrderListResDTO> selectMyOrders(String userId);
    List<OrderListResDTO> selectMyOrdersByStatus(Map<String, Object> map);
    List<OrderDetailResDTO> selectOrderDetails(int orderNo);
}
