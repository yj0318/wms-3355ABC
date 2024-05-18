package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;

import java.util.List;

public class ResultView {

    public static void dislplayOrderList(List<OrderListResDTO> orderlist) {
        if(orderlist.isEmpty()) {
            System.out.println("입력하신 정보에 맞는 주문이 없습니다!");
        }
        for(OrderListResDTO i : orderlist) {
            System.out.println(i);
        }
    }
}
