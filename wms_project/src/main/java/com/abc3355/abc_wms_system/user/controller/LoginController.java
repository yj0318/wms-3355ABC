package com.abc3355.abc_wms_system.user.controller;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;
import com.abc3355.abc_wms_system.user.service.LoginService;

import java.util.Map;

public class LoginController {
    private final LoginService loginService;
    public LoginController(){
        loginService = new LoginService();

    }

    public UserDTO headLoginSecondMenu(Map<String, String> loginMatch) {
        String userId = loginMatch.get("userId");
        String userPassword = loginMatch.get("userPassword");
        return loginService.loginServiceHead(userId, userPassword);
    }

    public UserDTO branchLoginSecondMenu(Map<String, String> loginMatch) {
        String userId = loginMatch.get("userId");
        String userPassword = loginMatch.get("userPassword");
        return loginService.loginService(userId, userPassword);
    }
}
