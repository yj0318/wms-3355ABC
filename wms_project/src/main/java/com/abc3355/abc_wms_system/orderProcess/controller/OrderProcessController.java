package com.abc3355.abc_wms_system.orderProcess.controller;

import com.abc3355.abc_wms_system.orderProcess.model.dto.GetOrderDetailDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderDetailResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderUpdateReqDTO;
import com.abc3355.abc_wms_system.orderProcess.model.service.OrderProcessService;
import com.abc3355.abc_wms_system.orderProcess.view.ResultView;

import java.util.List;

public class OrderProcessController {
    OrderProcessService orderProcessService = new OrderProcessService();
    ResultView resultView = new ResultView();
    /***
     * 본사 전체 조회
     */
    public void searchAllOrders() {
        List<OrderListResDTO> orderList = orderProcessService.searchAllOrders();
        resultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 본사 가맹점별 조회
     * @param name
     */
    public void searchOrdersByName(String name) {
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByName(name);
        resultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 본사 주문상태별 조회
     * @param status
     */
    public void searchOrdersByStatus(String status) {
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByStatus(status);
        resultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 가맹점 전체 조회
     * @param userId
     */
    public void searchMyOrders(String userId) {
        List<OrderListResDTO> orderList = orderProcessService.searchMyOrders(userId);
        resultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }
    /***
     * 가맹점 상태별 조회
     * @param userId
     * @param status
     */
    public void searchMyOrdersByStatus(String userId, int status) {
        List<OrderListResDTO> orderList = orderProcessService.searchMyOrdersByStatus(userId, status);
        resultView.dislplayOrderList(orderList, "입력하신 정보에 맞는 데이터가 없습니다!");
    }

    // -------------------------------------------------------------------------------------------- //
    /***
     * 본사 처리할 수 있는 주문 출력 & 가져오기
     * @return
     */
    public List<OrderListResDTO> printAndGetOrdersByStatus(String status) {
        List<OrderListResDTO> orderList = orderProcessService.searchOrdersByStatus(status);
        resultView.dislplayOrderList(orderList, "처리 가능한 주문이 없습니다!");
        return orderList;
    }

    /***
     * 위 메소드 오버로딩해서 해당 가맹점만 출력 & 가져오기
     * @param userId
     * @param status
     * @return
     */
    public List<OrderListResDTO> printAndGetOrdersByStatus(String userId, int status) {
        List<OrderListResDTO> orderList = orderProcessService.searchMyOrdersByStatus(userId, status);
        resultView.dislplayOrderList(orderList, "처리 가능한 주문이 없습니다!");
        return orderList;
    }

    /***
     * 주문 출고
     * @param orderUpdateReqDTO
     */
    public void processOrderShipment(OrderUpdateReqDTO orderUpdateReqDTO) {
        if(orderProcessService.processOrderShipment(orderUpdateReqDTO)) {
            resultView.displaySuccessMessage("orderShipment");
        } else {
            resultView.displayErrorMessage("orderShipment");
        }
    }

    /***
     * 주문 취소
     * @param orderUpdateReqDTO
     */
    public void cancelOrder (OrderUpdateReqDTO orderUpdateReqDTO) {
        if(orderProcessService.cancelOrder(orderUpdateReqDTO)) {
            resultView.displaySuccessMessage("cancelOrder");
        } else {
            resultView.displayErrorMessage("cancelOrder");
        }
    }

    /***
     * 주문 확정
     * @param orderUpdateReqDto
     */
    public void confirmOrder(OrderUpdateReqDTO orderUpdateReqDto) {
        if(orderProcessService.confirmOrder(orderUpdateReqDto)) {
            resultView.displaySuccessMessage("confirmOrder");
        } else {
            resultView.displayErrorMessage("confirmOrder");
        }
    }
    // ------------------------------------------------------------------------------------ //

    /***
     * 상세 주문 출력 및 가져오기
     * @param orderUpdateReqDto
     * @return
     */
    public List<GetOrderDetailDTO> getOrderDetails(OrderUpdateReqDTO orderUpdateReqDto) {
        List<GetOrderDetailDTO> orderDetails = orderProcessService.getOrderDetail(orderUpdateReqDto);
        resultView.displayOrderDetailList(orderDetails, "입력하신 정보에 맞는 데이터가 없습니다!");
        return orderDetails;
    }

    /***
     * 상세 주문 삭제
     * @param odNoToInt
     */
    public void deleteOrderDetail(int odNoToInt) {
        if(orderProcessService.deleteOrderDetail(odNoToInt)) {
            resultView.displaySuccessMessage("deleteOrderDetail");
        } else {
            resultView.displayErrorMessage("deleteOrderDetail");
        }
    }
}
