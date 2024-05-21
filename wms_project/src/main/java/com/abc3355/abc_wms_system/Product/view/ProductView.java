package com.abc3355.abc_wms_system.Product.view;

import com.abc3355.abc_wms_system.Product.controller.ProductController;
import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductView {

    ProductController productController = new ProductController();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;


    public void mainMenu() throws IOException {
        String menu = """
            ==== 매출관리 =====================================================================================
            1. 신상품 등록
            2. 상품 수정
            3. 상품 삭제
            4. 재고 등록
            5. 입고 기록 출력
            9. 이전으로
            =================================================================================================
            입력 : """;
        while(true) {
            System.out.print(menu);

            String choice = br.readLine();
            try{
                switch (choice) {
                    case "1" : productController.saveProduct(inputSaveProduct()); break;
                    case "2" : productController.updateProduct(inputUpdateProduct()); break;
                    case "3" : productController.deleteProduct(inputDeleteProduct()); break;
                    case "4" : productController.updateInventory(inputUpdateInventory()); break;
                    case "5" : productController.getReceivingRecord(); break;
                    case "9" : System.out.println("====== 종료 ======"); return;
                    default:
                        System.out.println("잘못된 값입니다. 다시 입력해주세요.");
                }
            }catch (Exception e) {
                System.out.println();
                System.out.println("형식에 맞게 다시 입력해주세요.");
                System.out.println();
            }
        }
    }

    private ProductSaveReqDto inputSaveProduct() throws IOException {
        System.out.println("==== 상품정보를 입력해주세요.===============================================================");
        System.out.println("상품이름 가격 만료여부 색깔정보 사이즈정보 카테고리정보 수량 창고번호");
        System.out.println("ex) 에어포스1_BK_210 139000 N 1 1 1 300 1");
        System.out.println("================================================================================================");
        System.out.println();

        st = new StringTokenizer(br.readLine().trim());

        ProductSaveReqDto productSaveReqDto = new ProductSaveReqDto(st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        return productSaveReqDto;
    }

    private ProductUpdateReqDto inputUpdateProduct() throws IOException{
        System.out.println();
        System.out.println("==========수정할 상품정보를 입력해주세요.=============");
        System.out.println("상품번호 상품이름 가격 만료여부 색깔정보 사이즈정보 카테고리정보");
        System.out.println("ex) 1 에어포스1_BK_210 139000 N 1 1 1");
        System.out.println("==============================================");
        System.out.println();

        st = new StringTokenizer(br.readLine().trim());

        ProductUpdateReqDto productUpdateReqDto = new ProductUpdateReqDto(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        return productUpdateReqDto;
    }

    private int inputDeleteProduct() throws IOException{
        System.out.println();
        System.out.println("==========삭제할 상품번호를 입력해주세요.==============================================================");
        System.out.println("상품번호");
        System.out.println("ex) 1");
        System.out.println("===============================================================================================");
        System.out.println();

        int productNo = Integer.parseInt(br.readLine().trim());

        return productNo;
    }

    private InventoryReqDto inputUpdateInventory() throws IOException {
        System.out.println();
        System.out.println("==========추가할 상품정보를 입력해주세요.==============================================================");
        System.out.println("상품번호 창고번호 수량");
        System.out.println("ex) 1 3 300");
        System.out.println("===============================================================================================");
        System.out.println();

        st = new StringTokenizer(br.readLine().trim());

        InventoryReqDto inventoryReqDto = new InventoryReqDto(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        return inventoryReqDto;
    }


}
