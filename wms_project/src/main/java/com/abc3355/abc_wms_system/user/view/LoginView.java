package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.user.controller.AddUserController;
import com.abc3355.abc_wms_system.user.controller.LoginController;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController = new LoginController();
    private AddUserController addUserController = new AddUserController();

    public void loginFirstMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. 본사");
            System.out.println("2. 가맹점");
            System.out.println("0. 종료하기");
            System.out.print("해당하는 계정을 선택하세요: ");
            int no = sc.nextInt();
            sc.nextLine();
            switch (no) {
                case 1 :
                    Map<String, String> loginMatchHead = headLoginFirstMenu();
                    UserDTO userHead = loginController.headLoginSecondMenu(loginMatchHead);
                    if (userHead != null) {
                    System.out.println("본사 로그인 성공");
                    headMainMenu();
                } else {
                    System.out.println("가맹점 로그인 실패");
                }
                break;
                case 2:
                    Map<String, String> loginMatch = branchLoginFirstMenu();
                    UserDTO user = loginController.branchLoginSecondMenu(loginMatch);
                    if (user != null) {
                        System.out.println("가맹점 로그인 성공");
                        branchMainMenu(user.getUserId());
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

    private void headMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("< 본사 > 메뉴");
        while (true){
            System.out.println("1. 주문관리");
            System.out.println("2. 재고조회");
            System.out.println("3. 상품관리");
            System.out.println("4. 매출관리");
            System.out.println("5. 가맹점 추가");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu){
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5:

                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }



    private Map<String, String> headLoginFirstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("본사 로그인");
        System.out.print("ID: ");
        String userId = sc.nextLine();
        System.out.print("PW: ");
        String userPassword = sc.nextLine();
        Map<String, String> loginMatchHead = new HashMap<>();
        loginMatchHead.put("userId", userId);
        loginMatchHead.put("userPassword", userPassword);
        return loginMatchHead;
    }

    private void branchMainMenu(String whId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("< " + whId + " > 메뉴");
        while (true){
            System.out.println("1. 상품조회");
            System.out.println("2. 주문서 작성");
            System.out.println("3. 재고 조회");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu){
                case 1: break;
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




}
