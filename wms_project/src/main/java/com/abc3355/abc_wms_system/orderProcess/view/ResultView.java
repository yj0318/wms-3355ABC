package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;

import java.util.List;

public class ResultView {
    public static void dislplayOrderList(List<OrderListResDTO> orderlist, String message) {
        if(orderlist.isEmpty()) {
            System.out.println(message);
        } else {
            for (OrderListResDTO i : orderlist) {
                System.out.println(i);
            }
        }
    }
}
