package com.abc3355.abc_wms_system.user.controller;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;
import com.abc3355.abc_wms_system.user.service.UserAddService;

public class AddUserController {
    private final UserAddService userAddService;

    public AddUserController(){
        userAddService = new UserAddService();
    }


}
