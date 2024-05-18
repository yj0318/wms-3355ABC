package com.abc3355.abc_wms_system.user.controller;

import com.abc3355.abc_wms_system.user.model.dao.UserInsert.LoginMapper;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.service.loginService;

import java.util.List;

public class LoginController {
    private final loginService loginService;
    public LoginController(){
        loginService = new loginService();

    }
    private LoginMapper loginMapper;

    public List<UserDTO> selectAllUser(){
        List<UserDTO> userDTOList = loginService.selectAllUser();
        return userDTOList;
    }


    private void branchLoginMenu() {
        System.out.println("로그인 성공");
    }

}
