package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.controller.SearchController;

import java.util.Scanner;

public class InventorySearchView {
    private SearchController searchController = new SearchController();
    private Scanner sc = new Scanner(System.in);

    public void searchMenu() {
        String menu = """
                ==================
                1. 전체 재고 조회
                2. 상세 재고 조회
                3. 품절 재고 확인
                4. 상품 재고 검색
                0. 이전 메뉴로
                ==================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String select = sc.next();
            switch (select) {
                case "1" : searchController.searchAllInventory(); break;
                case "2" : detailInventoryMenu(); break;
                case "3" : searchController.searchZeroInventory(); break;
                case "4" : searchController.searchInventoryName(inputName()); break;
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

    private void detailInventoryMenu() {
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
                case "1" : searchController.searchInvenByColor(inputColor()); break;
                case "2" : searchController.searchInvenBySize(inputSize()); break;
                case "3" : searchController.searchInvenByCategory(inputCategory()); break;
                case "0" : return;
                default:
                    System.out.println("올바른 숫자를 입력하세요. ");
            }
        }
    }

    private String inputCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 카테고리를 입력하세요(한글):");
        String category = sc.next();
        return category;
    }

    private int inputSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 사이즈를 입력해주세요(210~290까지 10단위): ");
        int size = sc.nextInt();
        return size;
    }

    private String inputColor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 색상을 입력해주세요(영문): ");
        String color = sc.nextLine();
        color = color.toUpperCase();
        return color;
    }
}
