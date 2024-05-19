package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.searchProduct.view.SearchMenuView;
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
                    branchMainMenu();
                } else {
                    System.out.println("가맹점 로그인 실패");
                }
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        } while (true);
    }

    private void branchMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("가맹점 메뉴");
        while (true){
            System.out.println("1. 상품조회");
            System.out.println("2. 주문서 작성");
            System.out.println("3. 재고 조회");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu){
                case 1: new SearchMenuView().searchMenu(); break;
                case 2: break;
                case 3: break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
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
