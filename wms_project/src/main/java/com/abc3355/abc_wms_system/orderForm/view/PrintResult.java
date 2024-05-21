package com.abc3355.abc_wms_system.orderForm.view;


import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.abc3355.abc_wms_system.user.view.LoginView.user;

public class PrintResult {

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode) {
            case "insert" : successMessage = "[[[[[신규 메뉴 등록을 성공하였습니다.]]]]]"; break;
            case "view" : successMessage="[[[[[주문서를 확인합니다.]]]]]"; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "insert" : errorMessage = "[[[[[신규 메뉴 등록을 실패하였습니다.]]]]]"; break;
            case "view" : errorMessage ="[[[[[주문서 확인을 실패하였습니다.]]]]]"; break;
        }
        System.out.println(errorMessage);
    }

    public void printInventoryList(List<InventoryConditionDTO> list) {
        System.out.println("================ 현재 주문 가능 재고 =====================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고현황", "가격", "색상", "사이즈(mm)");
        System.out.println("======================================================");
        for(InventoryConditionDTO inv : list){
            System.out.printf("%d\t%s\t%d\t%d\t%s\t%d\n",
                    inv.getProductId(),
                    inv.getProductName().split("_")[0],
                    inv.getInventoryAmount(),
                    inv.getProductPrice(),
                    inv.getColorName(),
                    inv.getSizeMm()
                    );
        }
    }

    /* name, color, size, amount 를 string 으로 받아옴*/
    public void printOrder(InputOrderDTO input) {

        OrderFormService orderFormService = new OrderFormService();

        int productNo = orderFormService.getProductNo(input);
        int orderNo = orderFormService.getLastOrderNo();
        int userNo = user.getUserNo();
        String userId = user.getUserId();

        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        System.out.println("============= 주문 확인서 ===============================");
        System.out.println("주문서번호 : " + orderNo);
        System.out.println("주문  날짜 : " + dateNow + " " + timeNow);
        System.out.println("주문자정보 : " + "(no. " + userNo + " ) " + userId);
        System.out.println("주문  상품 : " + "(no. " + productNo + " ) " + input.getProductName().split("_")[0] + " | " + input.getColor() + " | " + input.getSize() + "mm");
        System.out.println("주문  수량 : " + input.getProductAmount());
        System.out.println("============= 주문 확인서 ===============================");

    }
}


