package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;

import java.util.Scanner;

public class BranchesMenuView {
    private OrderProcessController orderProcessController = new OrderProcessController();
    private Scanner sc = new Scanner(System.in);
    public void mainMenu() {
        String menu = """
                ========================
                1. 주문 조회
                2. 주문 관리 (확정/취소)
                3. 주문 변경 (수정/삭제)
                0. 메인 메뉴 돌아가기
                ========================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : selectSearchMenu(); return;
                case "2" : return;
                case "0" : return;
                default :
                    System.out.println("잘못 입력했습니다!");
            }
        }
    }

    private void selectSearchMenu() {
        String menu = """
                ========================
                1. 전체 조회
                2. 출고 전 주문 조회
                3. 출고 완료 주문 조회
                4. 취소된 주문 조회
                0. 메인 메뉴 돌아가기
                ========================
                입력 : """;

    }


}
