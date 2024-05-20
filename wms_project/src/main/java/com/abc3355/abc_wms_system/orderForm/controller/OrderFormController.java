package com.abc3355.abc_wms_system.orderForm.controller;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;
import com.abc3355.abc_wms_system.orderForm.view.PrintResult;

import java.util.Map;

public class OrderFormController {

    private PrintResult printResult = new PrintResult();
    private OrderFormService orderFormService = new OrderFormService();


    public void insertOrderByNo(Map<String, String> parameter) {

        int no = Integer.parseInt(parameter.get("no"));
        int amount = Integer.parseInt(parameter.get("amount"));

        InsertNoAndAmountDTO input = new InsertNoAndAmountDTO();
        input.setNo(no);
        input.setAmount(amount);

        int totalOrderPrice = orderFormService.getTotalOrderPrice(input);
        int orderNo = orderFormService.getLastOrderNo();
//        int noInt = getProductNo(parameter);   // 민규님, [(type Map<String,String>) name,color,size] 드릴테니 int no를 돌려주세요.

        input.setOrderNo(orderNo);


        Boolean resultNo = orderFormService.insertOrderByTotalPrice(totalOrderPrice);
        Boolean resultAmount = orderFormService.insertOrderDetailAmount(input);

        if (resultNo && resultAmount) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

}



