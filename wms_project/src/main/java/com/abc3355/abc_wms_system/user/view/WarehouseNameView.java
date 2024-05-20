package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;

import java.util.List;

public class WarehouseNameView {
    public static void displayUserList(List<WarehouseInfoDTO> list) {
        if(list.isEmpty()) {
            System.out.println("등록된 가맹점이 없습니다.");
        }
        else {
            for(WarehouseInfoDTO warehouseInfoDTO : list) {
                System.out.println(warehouseInfoDTO.getWhId() + "  " + warehouseInfoDTO.getWhName());
            }
        }
    }
}
