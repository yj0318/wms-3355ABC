package com.abc3355.abc_wms_system.orderForm.controller;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.ProductInputDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;
import com.abc3355.abc_wms_system.orderForm.view.PrintResult;

import java.util.Map;

import static com.abc3355.abc_wms_system.user.view.LoginView.user;

public class OrderFormController {

    private PrintResult printResult = new PrintResult();
    private OrderFormService orderFormService = new OrderFormService();


    public void insertOrderByNo(Map<String, String> parameter) {

        InsertNoAndAmountDTO input = new InsertNoAndAmountDTO();

        int userNo = user.getUserNo();
        int productNo = getProductNo(parameter);   // 민규님, [(type Map<String,String>) name,color,size] 드릴테니 int no를 돌려주세요.
        int totalOrderPrice = orderFormService.getTotalOrderPrice(input);
        int orderNo = orderFormService.getLastOrderNo();
        int amount = Integer.parseInt(parameter.get("amount"));

        input.setUserNo(userNo);
        input.setProductNo(productNo);
        input.setTotalOrderPrice(totalOrderPrice);
        input.setAmount(amount);
        input.setOrderNo(orderNo);


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
        ProductInputDTO input = new ProductInputDTO();
        input.setProductName(parameter.get("name"));
        input.setColor(parameter.get("color"));
        input.setSize(Integer.parseInt(parameter.get("size")));

        no = orderFormService.getProductNo(input);

        return no;
    }

}



