package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;
import java.util.Scanner;

public class BranchesMenuView {
    private OrderProcessController orderProcessController = new OrderProcessController();
    private Scanner sc = new Scanner(System.in);
    public void mainMenu() {
        String userId = "gangnam";
        String menu = """
                ========================
                1. 주문 조회
                2. 주문 확정
                3. 주문 변경 (수정/삭제)
                0. 메인 메뉴 돌아가기
                ========================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : selectSearchMenu(userId); break;
                case "2" : break;
                case "3" : break;
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
                    System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
            }
        }
    }


}
