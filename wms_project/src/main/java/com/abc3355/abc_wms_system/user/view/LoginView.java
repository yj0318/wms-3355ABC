package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.user.controller.LoginController;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;

import java.util.Scanner;

public class LoginView {
    private LoginController loginController = new LoginController();


    public void branchLoginMenu(String userId, String userPassword) {
        for (UserDTO userDTO : loginController.selectAllUser()){
            if(userDTO.getUserId().equals(userId) && userDTO.getUserPassword().equals(userPassword) && userDTO.getUserType().equals("branch")){
                System.out.println("가맹점 로그인 성공");
            } else {
                System.out.println("가맹점 로그인 실패");
            }
        }
    }
}
