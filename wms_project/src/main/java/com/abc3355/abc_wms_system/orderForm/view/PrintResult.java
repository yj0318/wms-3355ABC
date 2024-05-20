package com.abc3355.abc_wms_system.orderForm.view;


public class PrintResult {

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode) {
            case "insert" : successMessage = "신규 메뉴 등록을 성공하였습니다."; break;
            case "view" : successMessage="주문서를 확인합니다."; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "insert" : errorMessage = "신규 메뉴 등록을 실패하였습니다."; break;
            case "view" : errorMessage ="주문서 확인을 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }
}


