package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderUpdateReqDTO;

import java.util.List;
import java.util.Scanner;

public class BranchesMenuView {
    private OrderProcessController orderProcessController = new OrderProcessController();
    private Scanner sc = new Scanner(System.in);
    public void mainMenu(   ) {
        String userId = "busan";

        String menu = """
                ========================
                1. 주문 조회
                2. 주문 확정
                3. 주문 변경 (수정/취소)
                0. 메인 메뉴 돌아가기
                ========================
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
                ========================
                1. 전체 주문 조회
                2. 출고전 주문 조회
                3. 출고완료 주문 조회
                4. 배송완료 주문 조회
                5. 취소된 주문 조회
                0. 이전 메뉴 돌아가기
                ========================
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
                ========================
                1. 주문 수정
                2. 주문 취소
                0. 이전 메뉴 돌아가기
                ========================
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
                ======== 처리가능 주문 목록 ========
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
        // else orderProcessController.updateOrder(orderUpdateReqDto);  // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
