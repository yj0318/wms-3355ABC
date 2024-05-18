package com.abc3355.abc_wms_system.salesManager.controller;

import com.abc3355.abc_wms_system.salesManager.View.PrintResult;
import com.abc3355.abc_wms_system.salesManager.model.dto.SelectBranchAndDateDTO;
import com.abc3355.abc_wms_system.salesManager.model.service.SalesManagerService;

import java.util.Map;

public class SalesManagerController {

    private final PrintResult printResult;
    private final SalesManagerService smService;

    public SalesManagerController() {
        printResult = new PrintResult();
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

        smService.selectByBranchAndDate(select);


    }
}
