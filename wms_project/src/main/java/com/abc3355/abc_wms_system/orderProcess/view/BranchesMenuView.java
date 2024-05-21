package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderForm.view.OrderFormView;
import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;
import com.abc3355.abc_wms_system.orderProcess.model.dto.GetOrderDetailDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderUpdateReqDTO;
import com.abc3355.abc_wms_system.user.view.LoginView;

import java.util.List;
import java.util.Scanner;

public class BranchesMenuView {
    private final OrderProcessController orderProcessController = new OrderProcessController();
    private final OrderFormView orderFormView = new OrderFormView();
    private Scanner sc = new Scanner(System.in);
    public void mainMenu(   ) {
        String userId = LoginView.user.getUserId();

        String menu = """
                ==== 주문 관리 ====================================================================================
                1. 주문 조회
                2. 주문 확정
                3. 주문 변경 (수정/취소)
                0. 메인 메뉴 돌아가기
                =================================================================================================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : selectSearchMenu(userId); break;
                case "2" : confirmOrder(userId); break;
                case "3" : selectProcessMenu(userId); break;
                case "0" : return;
                default :
                    System.out.println("잘못 입력했습니다!");
            }
        }
    }

    private void selectSearchMenu(String userId) {
        String menu = """
                =================================================================================================
                1. 전체 주문 조회
                2. 출고전 주문 조회
                3. 출고완료 주문 조회
                4. 배송완료 주문 조회
                5. 취소된 주문 조회
                0. 이전 메뉴 돌아가기
                =================================================================================================
                입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : orderProcessController.searchMyOrders(userId); return;
                case "2" : orderProcessController.searchMyOrdersByStatus(userId, 1); return;
                case "3" : orderProcessController.searchMyOrdersByStatus(userId, 2); return;
                case "4" : orderProcessController.searchMyOrdersByStatus(userId, 3); return;
                case "5" : orderProcessController.searchMyOrdersByStatus(userId, 4); return;
                case "0" : return;
                default:
                    System.out.println("잘못 입력했습니다! 다시 입력해주세요. (숫자)");
            }
        }
    }

    private void confirmOrder(String userId) {
        processMenu(3, userId);
    }

    private void selectProcessMenu(String userId) {
        String menu = """
                =================================================================================================
                1. 주문 수정
                2. 주문 취소
                0. 이전 메뉴 돌아가기
                =================================================================================================
                입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : processMenu(1, userId); break;
                case "2" : processMenu(2, userId); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력했습니다! 다시 입력해주세요. (숫자)");
            }
        }
    }

    public void processMenu(int num, String userId) {
        List<OrderListResDTO> orderList;
        System.out.print("""
                ==== 처리가능 주문 목록 ============================================================================
                """);
        if(num == 1 || num == 2) {
            orderList = orderProcessController.printAndGetOrdersByStatus(userId, 1);
        } else {
            orderList = orderProcessController.printAndGetOrdersByStatus(userId, 2);
        }

        if(orderList.isEmpty()) return;
        OrderUpdateReqDTO orderUpdateReqDto = new OrderUpdateReqDTO(inputOrderNumber(orderList));

        if(num == 2) orderProcessController.cancelOrder(orderUpdateReqDto);
        else if(num == 3) orderProcessController.confirmOrder(orderUpdateReqDto);
        else {
            inputUpdates(orderUpdateReqDto);
        }
    }

    private void inputUpdates(OrderUpdateReqDTO orderUpdateReqDto) {
        System.out.println("======== 상세 주문 리스트 ========");
        /**
         * 여기에 일단 해당 주문에 맞는 상세 주문 리스트 출력
         * 그 다음 1. 주문 추가 / 2. 주문 삭제 / 3. 주문 변경
         * 3개의 기능 추가
         * 3개의 기능 수행하기 그리고 여기 다시 돌아오기
         */

        List<GetOrderDetailDTO> orderDetails = orderProcessController.getOrderDetails(orderUpdateReqDto);

        while(true) {
            System.out.print("""
                        ========================
                        작업을 선택헤주세요
                        1. 주문 추가
                        2. 주문 삭제
                        0. 이전 메뉴 돌아가기
                        ========================
                        [상세 주문은 1개 이상 있어야 합니다. 전체 삭제 요청시 주문 취소 기능을 이용해주세요]
                        """);
            System.out.print("입력 : ");
            String op = sc.nextLine();
            switch (op) {
                case "1" : orderFormView.inputNewOrder(); break;
                case "2" : orderProcessController.deleteOrderDetail(inputOrderDetailNumber(orderDetails)); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다! 다시 입력해주세요. (숫자 형식)");
            }
        }
    }

    public GetOrderDetailDTO inputOrderDetailNumber(List<GetOrderDetailDTO> orderDetails) {

        while(true) {
            System.out.print("""
                    =================================
                    처리하실 상세 주문 번호를 입력해주세요
                    =================================
                    입력 : """);
            try {
                String odNo = sc.nextLine();
                int odNoToInt = Integer.parseInt(odNo);

                for (GetOrderDetailDTO i : orderDetails) {
                    if (i.getOdNo() == odNoToInt) {
                        return i;
                    }
                }
                System.out.println("잘못 입력하셨습니다! 처리 가능한 상세 주문 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하셨습니다! 숫자를 입력해주세요!");
            }
        }
    }

    public int inputOrderNumber(List<OrderListResDTO> orderList) {
        while (true) {
            System.out.print("처리할 주문 번호를 입력해 주세요 : ");
            try {
                String input = sc.nextLine();
                int inputToInt = Integer.parseInt(input);
                for (OrderListResDTO i : orderList) {
                    if (i.getOrderNo() == inputToInt) return inputToInt;
                }
                System.out.println("잘못 입력하셨습니다! 처리 가능한 주문 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하셨습니다! 숫자를 입력해주세요!");
            }
        }
    }
}
