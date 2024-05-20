package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.model.dto.ProductSearchDTO;

import java.util.List;

public class SearchResultView {

    public void searchProductList(List<ProductSearchDTO> list) {
            System.out.println("===================================================================");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "카테고리", "색상");
            System.out.println("===================================================================");
            for (ProductSearchDTO productSearchDTO : list) {
                System.out.printf("%d\t%s\t%d\t%s\t%s\t%s\n",
                        productSearchDTO.getProductNo(),
                        productSearchDTO.getProductName(),
                        productSearchDTO.getProductPrice(),
                        productSearchDTO.getIsExpire(),
                        productSearchDTO.getCategoryName(),
                        productSearchDTO.getColorName()
                );
            }
    }

    public void searchByColor(List<ProductSearchDTO> colorList) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "색상명");
        System.out.println("===================================================================");
        for (ProductSearchDTO productSearchDTO : colorList) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    productSearchDTO.getProductNo(),
                    productSearchDTO.getProductName(),
                    productSearchDTO.getProductPrice(),
                    productSearchDTO.getIsExpire(),
                    productSearchDTO.getColorName()
            );
        }
    }

    public void searchZeroProduct(List<ProductSearchDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무" ,"재고");
        System.out.println("===================================================================");
        for (ProductSearchDTO productSearchDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\n",
                    productSearchDTO.getProductNo(),
                    productSearchDTO.getProductName(),
                    productSearchDTO.getProductPrice(),
                    productSearchDTO.getIsExpire(),
                    productSearchDTO.getInventoryAmount()
            );
        }
    }

    public void searchByName(List<ProductSearchDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무");
        System.out.println("===================================================================");
        for (ProductSearchDTO productSearchDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\n",
                    productSearchDTO.getProductNo(),
                    productSearchDTO.getProductName(),
                    productSearchDTO.getProductPrice(),
                    productSearchDTO.getIsExpire()
            );
        }
    }

    public void searchBySize(List<ProductSearchDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무","사이즈(mm)");
        System.out.println("===================================================================");
        for (ProductSearchDTO productSearchDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    productSearchDTO.getProductNo(),
                    productSearchDTO.getProductName(),
                    productSearchDTO.getProductPrice(),
                    productSearchDTO.getIsExpire(),
                    productSearchDTO.getSizeMm()
            );
        }
    }

    public void searchByCategory(List<ProductSearchDTO> product) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "카테고리");
        System.out.println("===================================================================");
        for (ProductSearchDTO productSearchDTO : product) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    productSearchDTO.getProductNo(),
                    productSearchDTO.getProductName(),
                    productSearchDTO.getProductPrice(),
                    productSearchDTO.getIsExpire(),
                    productSearchDTO.getCategoryName()
            );
        }
    }

}

