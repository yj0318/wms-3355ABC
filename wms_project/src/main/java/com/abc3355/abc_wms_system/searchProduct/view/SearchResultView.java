package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;

import java.util.List;

public class SearchResultView {

    public void searchProductList(List<SearchProductDTO> list) {
            System.out.println("===================================================================");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "카테고리");
            System.out.println("===================================================================");
            for (SearchProductDTO searchProductDTO : list) {
                System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                        searchProductDTO.getProductNo(),
                        searchProductDTO.getProductName(),
                        searchProductDTO.getProductPrice(),
                        searchProductDTO.getIsExpire(),
                        searchProductDTO.getCategoryDTO().getCategoryName()
                );
            }
    }

    public void searchByColor(List<SearchProductDTO> colorList) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "색상명");
        System.out.println("===================================================================");
        for (SearchProductDTO searchProductDTO : colorList) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    searchProductDTO.getProductNo(),
                    searchProductDTO.getProductName(),
                    searchProductDTO.getProductPrice(),
                    searchProductDTO.getIsExpire(),
                    searchProductDTO.getColorDTO().getColorName()
            );
        }
    }

    public void searchZeroProduct(List<SearchProductDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무" ,"재고");
        System.out.println("===================================================================");
        for (SearchProductDTO searchProductDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\n",
                    searchProductDTO.getProductNo(),
                    searchProductDTO.getProductName(),
                    searchProductDTO.getProductPrice(),
                    searchProductDTO.getIsExpire(),
                    searchProductDTO.getInventoryDTO().getInventoryAmount()
            );
        }
    }

    public void searchByName(List<SearchProductDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무");
        System.out.println("===================================================================");
        for (SearchProductDTO searchProductDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\n",
                    searchProductDTO.getProductNo(),
                    searchProductDTO.getProductName(),
                    searchProductDTO.getProductPrice(),
                    searchProductDTO.getIsExpire()
            );
        }
    }

    public void searchBySize(List<SearchProductDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무","사이즈(mm)");
        System.out.println("===================================================================");
        for (SearchProductDTO searchProductDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    searchProductDTO.getProductNo(),
                    searchProductDTO.getProductName(),
                    searchProductDTO.getProductPrice(),
                    searchProductDTO.getIsExpire(),
                    searchProductDTO.getSizeDTO().getSizeMm()
            );
        }
    }

    public void searchByCategory(List<SearchProductDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "카테고리");
        System.out.println("===================================================================");
        for (SearchProductDTO searchProductDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    searchProductDTO.getProductNo(),
                    searchProductDTO.getProductName(),
                    searchProductDTO.getProductPrice(),
                    searchProductDTO.getIsExpire(),
                    searchProductDTO.getCategoryDTO().getCategoryName()
            );
        }
    }
}

