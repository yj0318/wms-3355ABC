package com.abc3355.abc_wms_system.searchProduct.controller;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventorySearchDTO;
import com.abc3355.abc_wms_system.searchProduct.model.dto.ProductSearchDTO;
import com.abc3355.abc_wms_system.searchProduct.model.service.SearchService;
import com.abc3355.abc_wms_system.searchProduct.view.InventoryResultView;
import com.abc3355.abc_wms_system.searchProduct.view.SearchResultView;

import java.util.List;

public class SearchController {

    private SearchResultView resultView = new SearchResultView();
    private SearchService searchService = new SearchService();
    private InventoryResultView invResultView = new InventoryResultView();

    public void searchAllProduct() {
            List<ProductSearchDTO> list = searchService.searchAllProduct();

            if (list != null) {
                resultView.searchProductList(list);
            } else {
                System.out.println("상품이 없습니다.");
            }
    }

    public void searchProductByColor(String color) {
        List<ProductSearchDTO> list = searchService.searchProductByColor(color);
        if (list != null) {
                resultView.searchByColor(list);
            }else {
                System.out.println("색상을 다시 입력해주세요.");
            }
    }

    public void searchZeroProduct() {
        List<ProductSearchDTO> product = searchService.searchZeroProduct();
        if (product != null) {
                resultView.searchZeroProduct(product);
        }else {
            System.out.println("품절된 상품이 없습니다.");
        }
    }

    public void searchProductName(String name) {
        List<ProductSearchDTO> product = searchService.searchProductName(name);
        if (product != null) {
                resultView.searchByName(product);
        }else {
            System.out.println("검색한 상품이 존재하지 않습니다.");
        }
    }

    public void searchProductBySize(int size) {
        List<ProductSearchDTO> product = searchService.searchProductSize(size);
        if (product != null) {
                resultView.searchBySize(product);
            }else {
            System.out.println("사이즈를 다시 입력해주세요");
        }
    }

    public void searchProductByCategory(String category) {
        List<ProductSearchDTO> product = searchService.searchProductCategory(category);
        if (product != null) {
            resultView.searchByCategory(product);
        } else {
            System.out.println("카테고리를 다시 입력해주세요.");
        }
    }

    public void searchAllInventory(int user) {
        List<InventorySearchDTO> list = searchService.searchAllInventory(user);
        if (list != null) {
            invResultView.showAllInventory(list);
        } else {
            System.out.println("상품이 없습니다.");
        }
    }

    public void searchInvenByColor(int user, String color) {
        List<InventorySearchDTO> list = searchService.searchInvenByColor(user, color);
        if (list != null) {
            invResultView.searchByColor(list);
        }else {
            System.out.println("색상을 다시 입력해주세요.");
        }
    }

    public void searchZeroInventory(int user) {
        List<InventorySearchDTO> inventory = searchService.searchZeroInventory(user);
        if (inventory != null) {
                invResultView.showZeroInventory(inventory);
        }else {
            System.out.println("품절된 상품이 없습니다.");
        }
    }

    public void searchInventoryName(int user, String name) {
        List<InventorySearchDTO> list = searchService.searchInventoryName(user,name);
        if (list != null) {
            invResultView.showInvenotryName(list);
        }else {
            System.out.println("알맞은 상품이 없습니다.");
        }
    }

    public void searchInvenBySize(int user, int size) {
        List<InventorySearchDTO> list = searchService.searchInvenBySize(user, size);
        if (list != null) {
            invResultView.showInventorySize(list);
        }else {
            System.out.println("알맞은 사이즈를 입력하세요.");
        }
    }

    public void searchInvenByCategory(int user, String category) {
        List<InventorySearchDTO> list = searchService.searchInvenByCategory(user, category);
        if (list != null) {
            invResultView.showInventoryCategory(list);
        }else {
            System.out.println("알맞은 카테고리를 입력하세요.");
        }
    }
}
