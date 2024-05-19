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
                4. 상품 검색
                0. 이전 메뉴로
                ==================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String select = sc.next();
            switch (select) {
                case "1" : searchController.searchAllProduct(); break;
                case "2" : detailSearchMenu(); break;
                case "3" : searchController.searchZeroProduct(); break;
                case "4" : searchController.searchProductName(inputName()); break;
                case "0" : return;
                default:
                    System.out.println("올바른 숫자를 입력하세요. ");
            }
        }
    }

    private String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 상품명을 입력하세요 : ");
        String name = sc.next();
        return name;
    }


    private void detailSearchMenu() {
        String menu = """
                    [상세 조회]
                ==================
                1. 색상으로 조회
                2. 사이즈로 조회
                3. 카테고리로 조회
                0. 이전 메뉴로
                ==================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String select = sc.next();
            switch (select) {
                case "1" : searchController.searchProductByColor(inputColor()); break;
//                case "2" : detailSearchMenu(); break;
//                case "3" : searchController.searchZeroProduct(); break;
                case "0" : return;
                default:
                    System.out.println("올바른 숫자를 입력하세요. ");
            }
        }
    }

    private int inputColor() {
        Scanner sc = new Scanner(System.in);
        String colorCode = """
                === 색상코드 ===
                1.BLACK
                2.GREEN
                3.GREY
                4.NAVY
                5.ORANGE
                6.RED
                7.SKYBLUE
                8.WHITE
                9.YELLOW               
                ===============
                검색할 색상코드를 입력해주세요 :""";
        System.out.print(colorCode);
        int color = sc.nextInt();
        return color;
    }

}
