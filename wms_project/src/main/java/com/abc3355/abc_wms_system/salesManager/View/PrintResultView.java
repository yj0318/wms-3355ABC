package com.abc3355.abc_wms_system.salesManager.View;

import com.abc3355.abc_wms_system.salesManager.model.dto.*;

import java.util.List;

public class PrintResultView {

    public void printBranchList(List<BranchDTO> list) {

        System.out.println("======================================");
        System.out.printf("%s\t%s\n", "가맹점번호", "가맹점명");
        System.out.println("======================================");
        for (BranchDTO branch : list) {
            System.out.printf("%d\t%s\n",
                    branch.getBranchNo(),
                    branch.getBranchName()
            );
        }
    }

    public void printOrder(List<SelectBranchOrderDTO> list) {
        System.out.println("==================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "주문번호", "가맹점번호", "가맹점명", "주문총액", "주문상태", "상세주문내용");
        System.out.println("==================================================================================================");
        for (SelectBranchOrderDTO order : list) {
            System.out.printf("%d\t%d\t%s\t%d\t%s\t%s\n",
                    order.getOrderNo(),
                    order.getUserNO(),
                    order.getUserName(),
                    order.getOrderPrice(),
                    order.getOrderStatusName(),
                    order.getOrderDate()
            );
        }
    }


    public void printAllOrder(List<OrderDTO> list) {
        System.out.println("==================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "주문번호", "주문날짜", "가맹점번호", "가맹점명", "주문총액", "주문상태", "상세주문내용");
        System.out.println("==================================================================================================");
        for (OrderDTO order : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\t%s\t%s\n",
                    order.getOrderNo(),
                    order.getOrderDate(),
                    order.getUserNo(),
                    order.getUserName(),
                    order.getOrderPrice(),
                    order.getOrderStatusName(),
                    order.getOrderDetail()
            );
        }
    }

    public void printProductList(List<ProductDTO> list) {
        System.out.println("==================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품번호", "상품명", "단종여부", "색상", "사이즈", "카테고리");
        System.out.println("==================================================================================================");
        for (ProductDTO product : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\t%s\t%s\n",
                    product.getProductNo(),
                    product.getProductName(),
                    product.getProductPrice(),
                    product.getIsExpire(),
                    product.getColorName(),
                    product.getSizeName(),
                    product.getCategoryName()
            );
        }
    }

    public void printProductSale(List<SelectProductSaleDTO> list) {
        System.out.println("==================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품번호", "상품명", "상품단가", "총 출고 수량", "총액");
        System.out.println("==================================================================================================");
        for (SelectProductSaleDTO product : list) {
            System.out.printf("%d\t%s\t%d\t%d\t%d\n",
                    product.getProductNo(),
                    product.getProductName(),
                    product.getProductPrice(),
                    product.getAmount(),
                    product.getTotalPrice()
            );
        }
    }

}
