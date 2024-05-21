package com.abc3355.abc_wms_system.orderForm.controller;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;
import com.abc3355.abc_wms_system.orderForm.view.PrintResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.abc3355.abc_wms_system.user.view.LoginView.user;

public class OrderFormController {

    private PrintResult printResult = new PrintResult();
    private OrderFormService orderFormService = new OrderFormService();


    public void insertOrderByNo(Map<String, String> parameter) {

        InsertNoAndAmountDTO input = new InsertNoAndAmountDTO();

        int userNo = user.getUserNo();
        int productNo = getProductNo(parameter);   // 민규님, [(type Map<String,String>) name,color,size] 드릴테니 int no를 돌려주세요.
        int orderNo = orderFormService.getLastOrderNo();
        int amount = Integer.parseInt(parameter.get("amount"));

        input.setUserNo(userNo);
        input.setProductNo(productNo);
        input.setAmount(amount);
        input.setOrderNo(orderNo);

        int totalOrderPrice = orderFormService.getTotalOrderPrice(input);
        input.setTotalOrderPrice(totalOrderPrice);


        System.out.println("productNo = " + productNo);
        System.out.println("totalOrderPrice = " + totalOrderPrice);


        Boolean resultOrder = orderFormService.insertOrderProduct(input);
        Boolean resultDetail = orderFormService.insertOrderDetail(input);

        if (resultOrder && resultDetail) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    private int getProductNo(Map<String, String> parameter) {
        int no;
        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(parameter.get("name"));
        input.setColor(parameter.get("color"));
        input.setSize(Integer.parseInt(parameter.get("size")));

        no = orderFormService.getProductNo(input);
        System.out.println("no = " + no);

        return no;
    }


    public int checkInvAmount(Map<String, String> parameter) {
        int result = 0;

        int amount = Integer.parseInt(parameter.get("amount"));
        int maxAmount;
        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(parameter.get("name"));
        input.setColor(parameter.get("color"));
        input.setSize(Integer.parseInt(parameter.get("size")));

        maxAmount = orderFormService.getMaxAmount(input);
        System.out.println("[[[[[maxAmount = " + maxAmount + "]]]]]");

        if(amount <= maxAmount && amount > 0) {
            result = 1;
        }

        return result;
    }

    public int printInvByProductName(String name) {
        int result = 0;

        List<InventoryConditionDTO> inventoryOrderForm = new ArrayList<>();
        inventoryOrderForm = orderFormService.printInvByProductName(name);

        if(inventoryOrderForm !=null) {
            result = 1;

            System.out.println("================ 현재 주문 가능 재고 ================");
            for(InventoryConditionDTO inv : inventoryOrderForm){
                System.out.println(inv);
            }
            System.out.println("=====================================================");

        } else {
            System.out.println("잘못된 검색어 입니다. 다시 선택해주세요.");
        }

        return result;
    }

    public int checkOpt(Map<String, String> parameter) {
        int result = 0;

        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(parameter.get("name"));
        input.setColor(parameter.get("color"));
        input.setSize(Integer.parseInt(parameter.get("size")));

        int checkNo = orderFormService.getProductNo(input);

        if(checkNo > 0) {
            result = 1;
            System.out.println("[[[[[옵션검사완료]]]]]");
        }

        return result;
    }
}



