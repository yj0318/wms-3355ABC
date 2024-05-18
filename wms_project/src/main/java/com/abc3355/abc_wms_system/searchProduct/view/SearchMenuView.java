package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.controller.SearchController;

import java.util.Scanner;

public class SearchMenuView {
    private SearchController searchController = new SearchController();
    private Scanner sc = new Scanner(System.in);

    public void searchMenu() {
        String menu = """
                ==================
                1. 전체 상품 조회
                2. 상세 상품 조회
                3. 품절 상품 확인
                0. 이전 메뉴로
                ==================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String select = sc.next();
            switch (select) {
                case "1" : searchController.searchAllProduct(); break;
//                case "2" : detailSearchMenu(); break;
//                case "3" : searchController.searchZeroProduct(); break;
                case "0" : return;
                default:
                    System.out.println("올바른 숫자를 입력하세요. ");
            }
        }
    }


}
