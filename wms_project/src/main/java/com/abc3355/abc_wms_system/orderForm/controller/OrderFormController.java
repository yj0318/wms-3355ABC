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
    private int userNo;
    private PrintResult printResult = new PrintResult();
    private OrderFormService orderFormService = new OrderFormService();



    public void insertOrderAndDetailList(int totalPriceResult, List<InputOrderDTO> detailList) {

        userNo = user.getUserNo();
        int result = 0;
        result = orderFormService.insertOrder(userNo, totalPriceResult,detailList);

        if (result == 1) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public int printInvByProductName(String name) {
        int result = 0;

        List<InventoryConditionDTO> inventoryOrderForm = new ArrayList<>();
        inventoryOrderForm = orderFormService.printInvByProductName(name);

        if(inventoryOrderForm != null) {
            result = 1;
            printResult.printInventoryList(inventoryOrderForm);
        } else {
            System.out.println("잘못된 검색어 입니다. 다시 선택해주세요.");
        }

        return result;
    }

    public int checkNo(Map<String, String> parameter) {
        int result = 0;

        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(parameter.get("name"));
        int no = Integer.parseInt(parameter.get("productNo"));
        input.setProductNo(no);

        int checkNo = 0;
        checkNo = orderFormService.getProductNo(input);

        if(checkNo != 0) {
            result = 1;
            System.out.println("[[[[[상품번호검사완료]]]]]");
        }

        return result;
    }

    public int checkInvAmount(Map<String, String> parameter) {
        int result = 0;

        int amount = Integer.parseInt(parameter.get("amount"));
        int maxAmount;
        InputOrderDTO input = new InputOrderDTO();
        input.setProductName(parameter.get("name"));
        input.setProductNo(Integer.parseInt(parameter.get("productNo")));

        maxAmount = orderFormService.getMaxAmount(input);
        System.out.println("[[[[[maxAmount = " + maxAmount + "]]]]]");

        if(amount <= maxAmount && amount >= 0) {
            result = 1;
        }

        return result;
    }


    public InputOrderDTO inputdetailList(Map<String, String> para) {

        InputOrderDTO input = new InputOrderDTO();

        int no = Integer.parseInt(para.get("productNo"));

        input.setProductNo(no);
        input.setProductName(orderFormService.getProductNameByNo(no));
        input.setProductPrice(Integer.parseInt(orderFormService.getProductPriceByNo(no)));
        input.setColor(orderFormService.getProductColorByNo(no));
        input.setSize(Integer.parseInt(orderFormService.getProductSizeByNo(no)));
        input.setAmount(Integer.parseInt(para.get("amount")));

        return input;
    }
}



