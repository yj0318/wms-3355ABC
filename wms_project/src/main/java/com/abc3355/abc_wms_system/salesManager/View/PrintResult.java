package com.abc3355.abc_wms_system.salesManager.View;

import com.abc3355.abc_wms_system.salesManager.model.dto.BranchDTO;

import java.util.List;

public class PrintResult {

    public void printBranchList(List<BranchDTO> branchList) {

        for(BranchDTO branch : branchList) {
            System.out.println(branch);
        }
    }


    // 성공과 실패에 대한 내용
    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "errorText":
                errorMessage = "❌잘못된 값을 입력했습니다❌ 다시 입력해주세요. ";
                break;
            case "orderList":
                errorMessage = "❌주문 조회를 실패했습니다 ❌";
                break;
            case "amountList":
                errorMessage = "❌출고량 조회를 실패했습니다 ❌";
                break;
        }
        System.out.println(errorMessage);
    }

}
