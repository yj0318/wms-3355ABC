package com.abc3355.abc_wms_system.searchProduct.controller;

import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;
import com.abc3355.abc_wms_system.searchProduct.model.service.SearchService;
import com.abc3355.abc_wms_system.searchProduct.view.SearchResultView;

import java.util.List;

public class SearchController {

    private SearchResultView resultView = new SearchResultView();
    private SearchService searchService = new SearchService();

    public void searchAllProduct() {
            List<SearchProductDTO> list = searchService.searchAllProduct();

            if (list != null) {
                resultView.searchProductList(list);
            } else {
                System.out.println("상품이 없습니다.");
            }
    }

    public void searchProductByColor(int color) {
        List<SearchProductDTO> list = searchService.searchProductByColor(color);
        if (list != null) {
            for (SearchProductDTO searchProductDTO : list) {
                resultView.searchByColor(list);
            }
        }else {
            System.out.println("알맞은 색상의 상품 코드를 입력해주세요");
            return;
        }
    }

    public void searchZeroProduct() {
        List<SearchProductDTO> product = searchService.searchZeroProduct();
        if (product != null) {
            for (SearchProductDTO searchProductDTO : product) {
                resultView.searchZeroProduct(product);
            }
        }else {
            System.out.println("품절된 상품이 없습니다.");
        }
    }

    public void searchProductName(String name) {
        List<SearchProductDTO> product = searchService.searchProductName(name);
        if (product != null) {
            for (SearchProductDTO searchProductDTO : product) {
                resultView.searchByName(product);
            }
        }else {
            System.out.println("알맞은 일므의 상품이 없습니다. ");
        }
    }
}
