package com.abc3355.abc_wms_system.user.controller;

import com.abc3355.abc_wms_system.user.model.dto.UserAndWarehouseDTO;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;
import com.abc3355.abc_wms_system.user.service.UserAddService;
import com.abc3355.abc_wms_system.user.view.WarehouseNameView;

import java.util.ArrayList;
import java.util.List;

public class AddUserController {
    private final UserAddService userAddService;

    public AddUserController(){
        userAddService = new UserAddService();
    }

    public void createNewBranch(UserAndWarehouseDTO userAndWarehouse) {
        userAddService.createNewBranch(userAndWarehouse);
    }


    public void showAllBranch() {
        try {
            List<WarehouseInfoDTO> list = userAddService.findAll();
            WarehouseNameView.displayUserList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
