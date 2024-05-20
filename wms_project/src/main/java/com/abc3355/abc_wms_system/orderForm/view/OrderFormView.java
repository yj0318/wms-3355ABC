package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class OrderFormView{
    private OrderFormController orderFormController = new OrderFormController();
    Scanner sc = new Scanner(System.in);


    public void orderFormMain() {

        do {
            System.out.print("주문하시겠습니까(Y/N) ? ");
            String input = sc.nextLine();

            if (input.toUpperCase().equals("Y")) {

                System.out.println("=================");
                System.out.println("주문을 신청받겠습니다.");
                System.out.println("=================");
                orderFormController.insertOrderByNo(newOrderByNo()); //상품번호,수량를 입력받습니다.

            } else {
                System.out.println("주문신청이 취소되었습니다.");
            }
        } while (true);
    }


    private Map<String, String> newOrderByNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("상품번호을 입력하세요 :");
        String no = sc.nextLine();
        System.out.println("수량을 입력하세요 :");
        String amount = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("no",no);
        parameter.put("amount",amount);
        return parameter;
    }

}