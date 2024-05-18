package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.contoller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.BranchOrderFormDTO;

import java.util.Scanner;



public class OrderFormView {
    private OrderFormController orderFormController = new OrderFormController();
    private Scanner sc = new Scanner(System.in);

    public void orderFormMain(){
        String order = """
                ========================
                상품을 입력하시겠습니까?
                ========================
                """;
        String input = sc.nextLine();
        if(input.toUpperCase().equals("Y")){
           orderFormController.insertOrder(orderFormView());
        }else {
            System.out.println("입력하지 않습니다.");
        }
    }




    private BranchOrderFormDTO orderFormView(){

        System.out.print("상품번호를 입력하세요 :");
        int orderNo = sc.nextInt();
        System.out.print("수량을 입력하세요 :");
        int  orderAmount = sc.nextInt();

        return new BranchOrderFormDTO(orderNo,orderAmount);
    }


}
