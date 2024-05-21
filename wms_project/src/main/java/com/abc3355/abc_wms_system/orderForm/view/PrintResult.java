package com.abc3355.abc_wms_system.orderForm.view;


import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;

import java.util.List;

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
}


