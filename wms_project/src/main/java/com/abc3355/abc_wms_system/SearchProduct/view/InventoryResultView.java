package com.abc3355.abc_wms_system.searchProduct.view;

import com.abc3355.abc_wms_system.searchProduct.model.dto.InventoryDTO;

import java.util.List;

public class InventoryResultView {
    public void showAllInventory(List<InventoryDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "재고" , "가격", "단종유무", "카테고리");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : list) {
            System.out.printf("%d\t%s\t%d\t%d\t%s\t%s\n",
                    inventoryDTO.getProductNo(),
                    inventoryDTO.getProductName(),
                    inventoryDTO.getInventoryAmount(),
                    inventoryDTO.getProductPrice(),
                    inventoryDTO.getIsExpire(),
                    inventoryDTO.getCategoryName()
            );
        }
    }

    public void searchByColor(List<InventoryDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "색상명");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    inventoryDTO.getProductNo(),
                    inventoryDTO.getProductName(),
                    inventoryDTO.getInventoryAmount(),
                    inventoryDTO.getIsExpire(),
                    inventoryDTO.getColorName()
            );
        }
    }

    public void showZeroInventory(List<InventoryDTO> inventory) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무" ,"재고");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : inventory) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\n",
                    inventoryDTO.getProductNo(),
                    inventoryDTO.getProductName(),
                    inventoryDTO.getProductPrice(),
                    inventoryDTO.getIsExpire(),
                    inventoryDTO.getInventoryAmount()
            );
        }
    }

    public void showInvenotryName(List<InventoryDTO> invenList) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무" ,"재고");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : invenList) {
            System.out.printf("%d\t%s\t%d\t%s\t%d\n",
                   inventoryDTO.getProductNo(),
                   inventoryDTO.getProductName(),
                   inventoryDTO.getProductPrice(),
                   inventoryDTO.getIsExpire(),
                   inventoryDTO.getInventoryAmount()
            );
        }
    }

    public void showInventorySize(List<InventoryDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "사이즈");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    inventoryDTO.getProductNo(),
                    inventoryDTO.getProductName(),
                    inventoryDTO.getInventoryAmount(),
                    inventoryDTO.getIsExpire(),
                    inventoryDTO.getSizeNo()
            );
        }
    }

    public void showInventoryCategory(List<InventoryDTO> list) {
        System.out.println("===================================================================");
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "상품코드", "상품명", "가격", "단종유무", "카테고리명");
        System.out.println("===================================================================");
        for (InventoryDTO inventoryDTO : list) {
            System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                    inventoryDTO.getProductNo(),
                    inventoryDTO.getProductName(),
                    inventoryDTO.getInventoryAmount(),
                    inventoryDTO.getIsExpire(),
                    inventoryDTO.getCategoryName()
            );
        }
    }
}
