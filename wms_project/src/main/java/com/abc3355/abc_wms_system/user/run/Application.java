package com.abc3355.abc_wms_system.user.run;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.view.LoginView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.loginFirstMenu();
    }



}
