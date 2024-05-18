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
                System.out.println("ERROR");
            }
    }
}
