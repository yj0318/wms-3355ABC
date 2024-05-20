package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputDataDTO;

import java.util.*;

import static com.abc3355.abc_wms_system.user.view.LoginView.user;


public class OrderFormView {
    private OrderFormController orderFormController = new OrderFormController();
    Scanner sc = new Scanner(System.in);


    public void orderFormMain() {

        do {
            System.out.print("주문하시겠습니까(Y/N) ? ");
            String input = sc.nextLine();

            if (input.toUpperCase().equals("Y")) {
//                orderFormController.insertOrderByNo(inputNewOrder()); //상품번호,수량를 입력받습니다.
                do{
                if(inputNewOrder() != null) {
                    orderFormController.insertOrderByNo(inputNewOrder()); // 입력한 상품 한 줄이 테이블에 insert됨
                }
                    System.out.println("상품을 추가 주문하시겠습니까(Y/N) ? ");
                    if (input.toUpperCase().equals("N")) {
                        break; }
                } while (true);
            } else {
                System.out.println("주문신청이 취소되었습니다.");
            }
        } while (true);
    }



    /**
     * 상품명(name), 색상(color), 사이즈(size), 수량(amount)를 얻는 메서드
     * @return Map<String,String> parameter
     */
    private Map<String,String> inputNewOrder() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> parameter = new HashMap<>();

        System.out.println("=====================");
        System.out.println("[주문서를 작성합니다.]");
        System.out.println("=====================");

        // 1. 상품명 입력
        do {
            System.out.println("상품명을 입력하세요 : ");
            String name = sc.nextLine();
            parameter.put("name",name);
            /* 민규님, 검색한 정보에 맞는 상세 정보(상품명, 단가, 재고수량, 옵션색상, 옵션사이즈) 출력해주세요. */
            if (orderFormController.printInvByProductName(name) == 0) {
                System.out.println("검색한 상품이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                break;
            }
        } while (true);

        // 2. 옵션 입력
        do {
            System.out.println("색상과 사이즈를 입력하세요(예: RED, 230) :");
            String[] strArr = (sc.nextLine()).split(", ");

            /* 입력한 옵션 값이 정상적인지 확인 '참이면 1, 거짓이면 0' */
            if (orderFormController.checkOpt(strArr[0], strArr[1]) == 0) {
                System.out.println("선택한 옵션이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                parameter.put("color",strArr[0]);
                parameter.put("size",strArr[1]);
                break;
            }
        } while (true);


        // 3. 수량 입력
        do {
            System.out.println("수량을 입력하세요 :");
            String amount = sc.nextLine();

            /* 민규님, 수량을 줄테니 재고랑 비교해서 '참이면 1, 거짓이면 0' 돌려주세요. */
            int result = orderFormController.checkInvAmount(amount);

            if (result == 0) {
                System.out.println("해당 수량은 주문 불가합니다. 다시 입력해주세요.");
            } else {
                parameter.put("amount","amount");
                break;
            }
        } while (true);


        return parameter;
    }

}