package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.model.dto.GetOrderDetailDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;

import java.util.List;

public class ResultView {
    public void dislplayOrderList(List<OrderListResDTO> orderlist, String message) {
        if(orderlist.isEmpty()) {
            System.out.println(message);
        } else {
            for (OrderListResDTO i : orderlist) {
                if(i.getOrderDetail() == null)
                    System.out.println(i);
                else
                    System.out.println(i.cancelOrder());
            }
        }
    }

    public void displayOrderDetailList(List<GetOrderDetailDTO> orderList, String message) {
        if(orderList.isEmpty()) {
            System.out.println(message);
        } else {
            for(GetOrderDetailDTO i : orderList) {
                System.out.println(i);
            }
        }
    }

    public void displayErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "cancelOrder" : errorMessage = "주문 취소에 실패하셨습니다.."; break;
            case "orderShipment" : errorMessage = "주문 출고에 실패하셨습니다.."; break;
            case "confirmOrder" : errorMessage = "주문 확정에 실패하셨습니다.."; break;
            case "deleteOrderDetail" : errorMessage = "상세 주문 삭제에 실패하셨습니다.."; break;
            case "insertOrderDetail" : errorMessage = "상세 주문 추가에 실패하셨습니다.."; break;
        }
        System.out.println(errorMessage);
    }

    public void displaySuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode) {
            case "cancelOrder" : successMessage = "주문 취소에 성공하셨습니다!"; break;
            case "orderShipment" : successMessage = "주문 출고에 성공하셨습니다!"; break;
            case "confirmOrder" : successMessage = "주문 확정에 성공하셨습니다!"; break;
            case "deleteOrderDetail" : successMessage = "상세 주문 삭제에 성공하셨습니다!"; break;
            case "insertOrderDetail" : successMessage = "상세 주문 추가에 성공하셨습니다!"; break;
        }
        System.out.println(successMessage);
    }

}
