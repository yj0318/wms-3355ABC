package com.abc3355.abc_wms_system.orderProcess.view;

import com.abc3355.abc_wms_system.orderProcess.controller.OrderProcessController;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderUpdateReqDTO;

import java.util.List;
import java.util.Scanner;

public class ManagerMenuView {

    private final OrderProcessController orderProcessController = new OrderProcessController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        String menu = """
                ==== 주문관리 =====================================================================================
                1. 주문 조회
                2. 주문 처리 (출고/취소)
                9. 메인 메뉴 돌아가기
                =================================================================================================
                입력 : """;

        while(true) {
            System.out.print(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" : searchMenu(); break;
                case "2" : processMenu(); break;
                case "9" : return;
                default :
                    System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
            }
        }
    }

    public void searchMenu() {
        String menu = """
                =================================================================================================
                1. 전체 조회
                2. 가맹점별 조회
                3. 상태별 조회
                0. 이전 메뉴 돌아가기
                =================================================================================================
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
                    System.out.println("잘못 입력했습니다! 다시 입력해주세요.");
            }
        }
    }

    public String inputBranchesName() {
        System.out.print("가맹점명을 입력해주세요 (입력 형식 : xx점) : ");
        return sc.nextLine();
    }

    public String inputBranchesStatus() {
        while (true) {
            System.out.print("""
            =================================================================================================
            1. 주문 처리중 조회
            2. 출고 완료 조회
            3. 주문 확정 조회
            4. 주문 취소 조회
            =================================================================================================
            입력 : """);
            String choice = sc.nextLine();
            String result = switch (choice) {
                case "1" -> "주문 처리중";
                case "2" -> "출고 완료";
                case "3" -> "주문 확정";
                case "4" -> "주문 취소";
                default -> "잘못된 값입니다. 다시 입력해주세요.";
            };
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("잘못 입력하셨습니다. 1 부터 4까지의 숫자를 입력하세요.");
            }
        }
    }

    public void processMenu() {
        System.out.print("""
                ======== 처리가능 주문 목록 ========
                """);
        List<OrderListResDTO> orderList = orderProcessController.printAndGetOrdersByStatus("주문 처리중");
        if(orderList.isEmpty()) return;

        OrderUpdateReqDTO orderUpdateReqDto = new OrderUpdateReqDTO(inputOrderNumber(orderList));
        String action = inputAction();

        if(action.equals("1")) {
            orderProcessController.processOrderShipment(orderUpdateReqDto);
        } else {
            // 이 부분에 String 취소 사유 작성해서 보내는 로직 필요하다.
            System.out.print("취소 사유 작성해주세요 : ");
            String message = sc.nextLine();
            orderProcessController.cancelOrder(orderUpdateReqDto);
        }
    }

    public int inputOrderNumber(List<OrderListResDTO> orderList) {
        while(true) {
            System.out.print("처리할 주문 번호를 입력해 주세요 : ");
            try {
                String input = sc.nextLine();
                int inputToInt = Integer.parseInt(input);
                for (OrderListResDTO i : orderList) {
                    if(i.getOrderNo() == inputToInt) return inputToInt;
                }
                System.out.println("잘못된 값입니다. 처리 가능한 주문 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 값입니다. 숫자를 입력해주세요.");
            }
        }
    }
    public String inputAction() {
        while (true) {
            System.out.print("처리 방식을 고르세요 (1.주문 출고 / 2.주문 취소) : ");
            String input = sc.nextLine();
            if (input.equals("1") || input.equals("2")) {
                return input;
            } else {
                System.out.println("잘못된 값입니다. 1 또는 2를 입력해 주세요.");
            }
        }
    }
}
