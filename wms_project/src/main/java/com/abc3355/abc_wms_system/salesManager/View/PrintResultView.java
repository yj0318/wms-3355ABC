package com.abc3355.abc_wms_system.salesManager.View;

import com.abc3355.abc_wms_system.salesManager.model.dto.BranchDTO;
import com.abc3355.abc_wms_system.salesManager.model.dto.OrderDTO;
import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;

import java.util.List;

public class PrintResultView {

    public void printBranchList(List<BranchDTO> branchList) {

        for(BranchDTO branch : branchList) {
            System.out.println(branch);
        }
    }


    public void printAllOrder(List<OrderDTO> list) {
        System.out.println("==================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "주문번호", "사용자번호", "사용자명", "주문총액", "주문상태", "상세주문내용");
        System.out.println("==================================================================================================");
        for (OrderDTO order : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\t%s\t%s\n",
                    order.getOrderNo(),
                    order.getOrderDate(),
                    order.getUserNo(),
                    order.getUserName(),
                    order.getOrderPrice(),
                    order.getOrderStatusName(),
                    order.getOrderDetail()
            );
        }
    }


    // 성공과 실패에 대한 내용
//    public void printErrorMessage(String errorCode) {
//
//        String errorMessage = "";
//        switch (errorCode) {
//            case "errorText":
//                errorMessage = "❌잘못된 값을 입력했습니다❌ 다시 입력해주세요. ";
//                break;
//            case "orderList":
//                errorMessage = "❌주문 조회를 실패했습니다 ❌";
//                break;
//            case "amountList":
//                errorMessage = "❌출고량 조회를 실패했습니다 ❌";
//                break;
//        }
//        System.out.println(errorMessage);
//    }

}
