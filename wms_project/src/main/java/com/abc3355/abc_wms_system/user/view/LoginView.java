package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.user.controller.LoginController;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController = new LoginController();

    public void loginFirstMenu() {
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("1. 본사");
            System.out.println("2. 가맹점");
            System.out.println("0. 종료하기");
            System.out.print("해당하는 계정을 선택하세요: ");
            int no = sc.nextInt();
            switch (no) {
                case 1 : headQuartersLogin();
                break;
                case 2:
                    Map<String, String> loginMatch = branchLoginFirstMenu();
                    UserDTO user = loginController.branchLoginSecondMenu(loginMatch);
                    if (user != null) {
                    System.out.println("가맹점 로그인 성공");

                } else {
                    System.out.println("가맹점 로그인 실패");
                }
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        } while (true);
    }

    private Map<String, String> branchLoginFirstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("가맹점 로그인");
        System.out.print("ID : ");
        String userId = sc.nextLine();
        System.out.print("PW: ");
        String userPassword = sc.nextLine();
        Map<String, String> loginMatch = new HashMap<>();
        loginMatch.put("userId", userId);
        loginMatch.put("userPassword", userPassword);
        return loginMatch;
    }


    private void headQuartersLogin() {
    }


}
