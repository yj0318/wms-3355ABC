package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;

import java.util.*;


public class OrderFormView {
    private final OrderFormController orderFormController = new OrderFormController();

    int result = 0;

    public void orderFormMain() {

        Scanner sc = new Scanner(System.in);

        while (result != 3) {

            System.out.print("새 주문서를 작성합니다. 진행하려면 '예'를 입력해주세요 : ");
            String input = sc.nextLine();

            if (input.equals("예")) {
                Map<String, String> para;
                para = inputNewOrder();
                result = checkOrder(para);
                System.out.println("result = " + result);
                switch (result) {            // 주문을 (확정진행/작성(수정)/취소) 할지를 확인 / 취소 == 0
                    case 1:
                        orderFormController.insertOrderByNo(para); // 입력한 주문을 테이블에 INSERT
                        result = 0;
                        break;
                    case 2:
                        result = 0;
                        break;
                    default:
                        System.out.println("감사합니다. 주문신청이 종료되었습니다.");
                        return;
                }
            } else {
                System.out.println("주문신청이 취소되었습니다.");
                return;
            }
        }
    }

    /**
     * 입력한 주문을 (확정진행/재작성/취소) 할지를 확인
     *
     * @param para :  검색상품명(name), 상품번호(productNo), 수량(amount)
     */
    public int checkOrder(Map<String, String> para) {

        PrintResult pr = new PrintResult();
        Scanner sc = new Scanner(System.in);

        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(para.get("name"));
        input.setProductNo(Integer.parseInt(para.get("productNo")));
        input.setProductAmount(Integer.parseInt(para.get("amount")));

        while (result == 0) {
            pr.printOrder(input);   // 주문 확인서 출력
            System.out.println("[주문 확정 하시겠습니까?]");
            System.out.println("1. 주문 확정");
            System.out.println("2. 주문 수정");
            System.out.println("3. 주문 취소");
            String no = sc.nextLine();

            switch (no) {
                case "1":
                    System.out.println("주문을 저장합니다.");
                    result = 1;
                    break;
                case "2":
                    System.out.println("주문을 수정합니다.");
                    result = 2;
                    break;
                case "3":
                    result = 3;
                    break;
                default:
                    System.out.println("잘못된 값입니다. 다시 입력해주세요.");
            }
        }
        return result;
    }


    /**
     * 검색상품명(name), 상품번호(productNo), 수량(amount)를 얻는 메서드
     * @return Map<String, String> parameter
     */
    public Map<String, String> inputNewOrder() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> parameter = new HashMap<>();

        System.out.println("==== 주문서 작성 ==================================================================================");

        // 1. 상품명 입력
        do {
            System.out.println("상품명을 입력하세요 : ");
            String name = sc.nextLine();
            parameter.put("name", name);

            if (orderFormController.printInvByProductName(name) == 0) {
                System.out.println("검색한 상품이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                break;
            }
        } while (true);


        // 2. 상품 번호 입력
        do {
            System.out.println("주문할 상품 번호를 입력하세요 :");
            String no = sc.nextLine().trim();
            parameter.put("productNo",no);

            if (orderFormController.checkNo(parameter) == 0) {
                System.out.println("선택한 상품 번호가 존재하지 않습니다. 다시 입력해주세요.");
            } else {
                parameter.put("productNo",no);
                break;
            }
        } while (true);



        // 3. 수량 입력
        do {
            System.out.println("수량을 입력하세요 :");
            String amount = sc.nextLine();
            parameter.put("amount", amount);

            int result = orderFormController.checkInvAmount(parameter);

            if (result == 0) {
                System.out.println("해당 수량은 주문 불가합니다. 다시 입력해주세요.");
            } else {
                break;
            }
        } while (true);


        return parameter;
    }
}