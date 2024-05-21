package com.abc3355.abc_wms_system.Product.controller;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.StoreStatusRecordResDto;
import com.abc3355.abc_wms_system.Product.model.service.InventoryServicePP;
import com.abc3355.abc_wms_system.Product.model.service.ProductService;

import java.util.List;

public class ProductController {

    ProductService productService = new ProductService();
    InventoryServicePP inventoryServicePP = new InventoryServicePP();

    /**
     * 여기서 resultView로 보여줌
     */

    /**
     * 신상품 등록
     */
    public void saveProduct(ProductSaveReqDto productSaveReqDto){

        int productNo = productService.saveProduct(productSaveReqDto);

        if(productNo > 0){
            System.out.println("상품을 성공적으로 저장했습니다.");
            System.out.println("상품번호 : " + productNo);
            System.out.println("======================");
            System.out.println();
        }
        else{
            System.out.println("상품 저장에 실패했습니다. 다시 시도해주세요.");
            System.out.println("상품번호 : " + productNo);
            System.out.println("================================");
            System.out.println();
        }

    }


    /**
     * 상품 수정
     */
    public void updateProduct(ProductUpdateReqDto productUpdateReqDto){

        int i = productService.updateProduct(productUpdateReqDto);

        if(i == 1){
            System.out.println("상품을 성공적으로 수정했습니다..");
            System.out.println("상품번호 : " + productUpdateReqDto.getProductNo());
            System.out.println("======================");
            System.out.println();
        }
        else{
            System.out.println("상품 수정에 실패했습니다. 다시 시도해주세요.");
            System.out.println("상품번호 : " + productUpdateReqDto.getProductNo());
            System.out.println("================================");
            System.out.println();
        }

    }



    /**
     * 상품 삭제
     */
    public void deleteProduct(int productNo){

        int i = productService.deleteProduct(productNo);

        if(i == 1){
            System.out.println();
            System.out.println("상품을 성공적으로 삭제했습니다.");
            System.out.println("상품번호 : " + productNo);
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("상품 삭제에 실패했습니다. 다시 시도해주세요.");
            System.out.println("상품번호 : " + productNo);
            System.out.println();
        }

    }


    /**
     * ======================================================
     */

    /**
     * 재고 등록(기존상품 수량 추가)
     */
    public void updateInventory(InventoryReqDto inventoryReqDto){

        int i = inventoryServicePP.updateInventory(inventoryReqDto);

        if(i == 1){
            System.out.println();
            System.out.println("======================");
            System.out.println("재고를 성공적으로 수정했습니다.");
            System.out.println("상품번호 : " + inventoryReqDto.getProductNo());
            System.out.println("======================");
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("================================");
            System.out.println("재고 수정에 실패했습니다. 다시 시도해주세요.");
            System.out.println("상품번호 : " + inventoryReqDto.getProductNo());
            System.out.println("================================");
            System.out.println();
        }

    }



    /**
     * 입고기록 조회
     */
    public void getReceivingRecord(){

        List<StoreStatusRecordResDto> receivingRecord = inventoryServicePP.getReceivingRecord();

        System.out.println();
        System.out.println("==============================================");
        for (StoreStatusRecordResDto recordResDto : receivingRecord) {
            System.out.println("---------------------------------");
            System.out.println("입고번호 : " + recordResDto.getNo());
            System.out.println("입고량 : " + recordResDto.getAmount());
            System.out.println("입고일 : " + recordResDto.getDate());
            System.out.println("상품번호 : " + recordResDto.getProductNo());
            System.out.println("---------------------------------");
        }
        System.out.println("==============================================");
        System.out.println();

    }


}
