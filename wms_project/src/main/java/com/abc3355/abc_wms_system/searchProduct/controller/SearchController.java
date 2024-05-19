package com.abc3355.abc_wms_system.searchProduct.controller;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventoryDTO;
import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;
import com.abc3355.abc_wms_system.searchProduct.model.service.SearchService;
import com.abc3355.abc_wms_system.searchProduct.view.InventoryResultView;
import com.abc3355.abc_wms_system.searchProduct.view.SearchResultView;

import java.util.List;

public class SearchController {

    private SearchResultView resultView = new SearchResultView();
    private SearchService searchService = new SearchService();
    private InventoryResultView invResultView = new InventoryResultView();

    public void searchAllProduct() {
            List<SearchProductDTO> list = searchService.searchAllProduct();

            if (list != null) {
                resultView.searchProductList(list);
            } else {
                System.out.println("상품이 없습니다.");
            }
    }

    public void searchProductByColor(String color) {
        List<SearchProductDTO> list = searchService.searchProductByColor(color);
        if (list != null) {
                resultView.searchByColor(list);
            }if (list == null || list.size() == 0) {
                System.out.println("색상을 다시 입력해주세요.");
            }
    }

    public void searchZeroProduct() {
        List<SearchProductDTO> product = searchService.searchZeroProduct();
        if (product != null) {
                resultView.searchZeroProduct(product);
        }else {
            System.out.println("ERROR");
        }
    }

    public void searchProductName(String name) {
        List<SearchProductDTO> product = searchService.searchProductName(name);
        if (product != null) {
                resultView.searchByName(product);
        }else {
            System.out.println("ERROR");
        }
    }

    public void searchProductBySize(int size) {
        List<SearchProductDTO> product = searchService.searchProductSize(size);
        if (product != null) {
                resultView.searchBySize(product);
            }if (product == null) {
            System.out.println("사이즈를 다시 입력해주세요");
        }else {
            System.out.println("ERROR");
        }
    }

    public void searchProductByCategory(String category) {
        List<SearchProductDTO> product = searchService.searchProductCategory(category);
        if (product != null) {
            resultView.searchByCategory(product);
        } else if (product == null) {
            System.out.println("카테고리를 다시 입력해주세요.");
        }
    }

    public void searchAllInventory() {
        List<InventoryDTO> list = searchService.searchAllInventory();
        if (list != null) {
            invResultView.showAllInventory(list);
        } else {
            System.out.println("상품이 없습니다.");
        }
    }

    public void searchInvenByColor(String color) {
        List<InventoryDTO> list = searchService.searchInvenByColor(color);
        if (list != null) {
            invResultView.searchByColor(list);
        }if (list == null) {
            System.out.println("색상을 다시 입력해주세요.");
        }
    }

    public void searchZeroInventory() {
        List<InventoryDTO> inventory = searchService.searchZeroInventory();
        if (inventory != null) {
                invResultView.showZeroInventory(inventory);
        }else if (inventory == null) {
            System.out.println("품절된 상품이 없습니다.");
        }
    }

    public void searchInventoryName(String name) {
        List<InventoryDTO> list = searchService.searchInventoryName(name);
        if (list != null) {
            invResultView.showInvenotryName(list);
        }else if (list == null) {
            System.out.println("알맞은 상품이 없습니다.");
        }
    }
}
