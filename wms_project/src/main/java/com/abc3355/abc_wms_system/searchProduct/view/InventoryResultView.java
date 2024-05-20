package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventorySearchDTO;

import java.util.List;

public class InventoryResultView {
    public void showAllInventory(List<InventorySearchDTO> list) {
        System.out.println("=================================================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고현황" , "가격", "단종유무", "카테고리", "색상", "사이즈(mm)");
        System.out.println("=================================================================================================");
        for (InventorySearchDTO inventorySearchDTO : list) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\t%s\t%s\t%d\n",
                    inventorySearchDTO.getProductNo(),
                    inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                    inventorySearchDTO.getProductPrice(),
                    inventorySearchDTO.getIsExpire(),
                    inventorySearchDTO.getCategoryName(),
                    inventorySearchDTO.getColorName(),
                    inventorySearchDTO.getSizeMm()
            );
        }
    }

    public void searchByColor(List<InventorySearchDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명","재고현황","가격", "단종유무", "색상명");
        System.out.println("===================================================================");
        for (InventorySearchDTO inventorySearchDTO : list) {
            System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n",
                    inventorySearchDTO.getProductNo(),
                    inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                    inventorySearchDTO.getProductPrice(),
                    inventorySearchDTO.getIsExpire(),
                    inventorySearchDTO.getColorName()
            );
        }
    }

    public void showZeroInventory(List<InventorySearchDTO> inventory) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고", "가격", "단종유무");
        System.out.println("===================================================================");
        for (InventorySearchDTO inventorySearchDTO : inventory) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\n",
                    inventorySearchDTO.getProductNo(),
                    inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                    inventorySearchDTO.getProductPrice(),
                    inventorySearchDTO.getIsExpire()

            );
        }
    }

    public void showInvenotryName(List<InventorySearchDTO> invenList) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고", "가격", "단종유무");
        System.out.println("===================================================================");
        for (InventorySearchDTO inventorySearchDTO : invenList) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\n",
                   inventorySearchDTO.getProductNo(),
                   inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                   inventorySearchDTO.getProductPrice(),
                   inventorySearchDTO.getIsExpire()
            );
        }
    }

    public void showInventorySize(List<InventorySearchDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고", "가격","단종유무", "사이즈");
        System.out.println("===================================================================");
        for (InventorySearchDTO inventorySearchDTO : list) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\t%s\n",
                    inventorySearchDTO.getProductNo(),
                    inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                    inventorySearchDTO.getProductPrice(),
                    inventorySearchDTO.getIsExpire(),
                    inventorySearchDTO.getSizeMm()
            );
        }
    }

    public void showInventoryCategory(List<InventorySearchDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고", "가격","단종유무", "카테고리명");
        System.out.println("===================================================================");
        for (InventorySearchDTO inventorySearchDTO : list) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\t%s\n",
                    inventorySearchDTO.getProductNo(),
                    inventorySearchDTO.getProductName(),
                    inventorySearchDTO.getInventoryAmount(),
                    inventorySearchDTO.getProductPrice(),
                    inventorySearchDTO.getIsExpire(),
                    inventorySearchDTO.getCategoryName()
            );
        }
    }
}
