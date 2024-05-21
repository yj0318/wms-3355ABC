package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;

import java.util.*;


public class OrderFormView {
    private final OrderFormController orderFormController = new OrderFormController();


    public void orderFormMain() {

            Scanner sc = new Scanner(System.in);

            System.out.print("새 주문서를 작성합니다. 진행하려면 '예'를 입력해주세요 : ");
            String input = sc.nextLine();

            if (input.toUpperCase().equals("예")) {
            do{
                Map<String,String> para;
                para = inputNewOrder();
                checkOrder(para);            // 주문을 (확정진행/작성(수정)/취소) 할지를 확인 / 취소 == 0
                } while (true);
            } else {
                System.out.println("주문신청이 취소되었습니다.");
            }
    }

    /**
     * 입력한 주문을 (확정진행/재작성/취소) 할지를 확인
     * @param para :  상품명(name), 색상(color), 사이즈(size), 수량(amount)
     */
    public void checkOrder(Map<String, String> para) {

        PrintResult pr = new PrintResult();
        Scanner sc = new Scanner(System.in);

        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(para.get("name"));
        input.setColor(para.get("color"));
        input.setSize(Integer.parseInt(para.get("size")));
        input.setProductAmount(Integer.parseInt(para.get("amount")));

        do {
//            pr.printOrder(input);   // 주문 확인서 출력
            System.out.println("[주문 확정 하시겠습니까?]");
            System.out.println("1. 주문 확정");
            System.out.println("2. 주문 수정");
            System.out.println("3. 주문 취소");
            String no = sc.nextLine();

            switch (no) {
                case "1" :
                    System.out.println("주문을 저장합니다.");
                    orderFormController.insertOrderByNo(para); // 입력한 주문을 테이블에 INSERT
                    break;
                case "2" :
                    System.out.println("주문을 수정합니다.");
                    orderFormMain(); // 주문메뉴 재전송
                    break;
                case "3" : break;
                default:
                    System.out.println("잘못된 값입니다. 다시 입력해주세요.");
            }
        }while (true);
    }


    /**
     * 상품명(name), 색상(color), 사이즈(size), 수량(amount)를 얻는 메서드
     * @return Map<String,String> parameter
     */
    public Map<String,String> inputNewOrder() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> parameter = new HashMap<>();

        System.out.println("==== 주문서 작성 ==================================================================================");

        // 1. 상품명 입력
        do {
            System.out.println("상품명을 입력하세요 : ");
            String name = sc.nextLine();
            parameter.put("name",name);

            if (orderFormController.printInvByProductName(name) == 0) {
                System.out.println("검색한 상품이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                break;
            }
        } while (true);

        // 2. 옵션 입력
        do {
            System.out.println("색상과 사이즈를 입력하세요(예: RED, 230) :");
            String[] strArr = (sc.nextLine()).split(",");
            parameter.put("color",strArr[0].toUpperCase().trim());
            parameter.put("size",strArr[1].trim());

            if (orderFormController.checkOpt(parameter) == 0) {
                System.out.println("선택한 옵션이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                parameter.put("color",strArr[0].toUpperCase());
                parameter.put("size",strArr[1]);
                break;
            }
        } while (true);


        // 3. 수량 입력
        do {
            System.out.println("수량을 입력하세요 :");
            String amount = sc.nextLine();
            parameter.put("amount",amount);

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