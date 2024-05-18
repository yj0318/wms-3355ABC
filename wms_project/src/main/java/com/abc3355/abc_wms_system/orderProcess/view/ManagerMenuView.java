package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;

import java.util.Scanner;

public class ManagerMenuView {

    private OrderProcessController orderProcessController = new OrderProcessController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        String menu = """
                ========================
                1. 주문 조회
                2. 주문 (출고/취소)
                0. 메인 메뉴 돌아가기
                ========================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : selectSearchMenu(); return;
                case "2" : selectProcessMenu(); return;
                case "0" : return;
                default :
                    System.out.println("잘못 입력했습니다!");
            }
        }
    }
    public void selectSearchMenu() {
        String menu = """
                ========================
                1. 전체 조회
                2. 가맹점별 조회
                3. 상태별 조회
                0. 메인 메뉴 돌아가기
                ========================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : orderProcessController.searchAllOrders(); break;
                case "2" : orderProcessController.searchOrdersByName(inputBranchesName()); break;
                case "3" : orderProcessController.searchOrdersByStatus(inputBranchesStatus()); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력했습니다!");
            }
        }
    }
    public String inputBranchesName() {
        System.out.print("가맹점명을 입력해주세요 (입력 형식 : xx점) : ");
        return sc.nextLine();
    }
    public String inputBranchesStatus() {
        String choice = "";
        while(true) {
            System.out.print("""
                    ========================
                    1. 주문 처리중 조회
                    2. 출고 완료 조회
                    3. 주문 확정 조회
                    4. 주문 취소 조회
                    ========================
                    입력 : """);
            choice = sc.nextLine();
            switch (choice) {
                case "1" : choice = "주문 처리중"; break;
                case "2" : choice = "출고 완료"; break;
                case "3" : choice = "주문 확정"; break;
                case "4" : choice = "주문 취소"; break;
                default: break;
            }
            if(choice.equals("주문 처리중") || choice.equals("출고 완료") ||choice.equals("주문 확정") || choice.equals("주문 취소")) {
                return choice;
            } else {
                System.out.println("잘못 입력하셨습니다! 다시 입력하세요.");
            }
        }
    }
    private void selectProcessMenu() {

    }
}
