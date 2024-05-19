package com.abc3355.abc_wms_system.orderProcess.controller;

import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderDetailResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.service.OrderProcessService;
import com.abc3355.abc_wms_system.orderProcess.view.ResultView;

import java.util.List;

public class OrderProcessController {
    OrderProcessService orderProcessService = new OrderProcessService();
    /***
     * 본사 전체 조회
     */
    public void searchAllOrders() {
        List<OrderListResDTO> orderList = orderProcessService.searchAllOrders();
        ResultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 본사 가맹점별 조회
     * @param name
     */
    public void searchOrdersByName(String name) {
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByName(name);
        ResultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 본사 주문상태별 조회
     * @param status
     */
    public void searchOrdersByStatus(String status) {
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByStatus(status);
        ResultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 가맹점 전체 조회
     * @param userId
     */
    public void searchMyOrders(String userId) {
        List<OrderListResDTO> orderList = orderProcessService.searchMyOrders(userId);
        ResultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 가맹점 상태별 조회
     * @param userId
     * @param status
     */
    public void searchMyOrdersByStatus(String userId, int status) {
        List<OrderListResDTO> orderList = orderProcessService.searchMyOrdersByStatus(userId, status);
        ResultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }

    // ---------------------------------------------------------------------------- //
    /***
     * 본사 처리할 수 있는 주문 출력 & 가져오기
     * @return
     */
    public List<OrderListResDTO> printAndGetOrdersByStatus() {
        String status = "주문 처리중";
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByStatus(status);
        ResultView.dislplayOrderList(orderList, "처리 가능한 주문이 없습니다!");
        return orderList;
    }

    public void searchOrderDetails(int orderNo) {
        List<OrderDetailResDTO> orderDetailList = orderProcessService.searchOrderDetails(orderNo);
    }
}
