package com.abc3355.abc_wms_system.salesManager.controller;

import com.abc3355.abc_wms_system.salesManager.View.PrintResultView;
import com.abc3355.abc_wms_system.salesManager.model.dto.*;
import com.abc3355.abc_wms_system.salesManager.model.service.SalesManagerService;

import java.util.List;
import java.util.Map;

public class SalesManagerController {

    private final PrintResultView printResultView;
    private final SalesManagerService smService;

    public SalesManagerController() {
        printResultView = new PrintResultView();
        smService = new SalesManagerService();
    }

    public void selectByBranchAndDate(Map<String, String> parameter) {

        int no = (Integer.parseInt(parameter.get("no")));
        String start = parameter.get("startDate");
        String end = parameter.get("endDate");

        SelectBranchAndDateDTO select = new SelectBranchAndDateDTO();
        select.setNo(no);
        select.setStartDate(start);
        select.setEndDate(end);

        List<SelectBranchOrderDTO> order = smService.selectByBranchAndDate(select);
        printResultView.printOrder(order);
    }

    public void selectAllOrder() {
        List<OrderDTO> orderList = smService.selectAllOrder();

        printResultView.printAllOrder(orderList);

    }

    public void selectProductSale(int no) {
        List<SelectProductSaleDTO> productList = smService.selectProductSale(no);

        printResultView.printProductSale(productList);
    }

}
