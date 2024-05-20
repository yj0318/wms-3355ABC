package com.abc3355.abc_wms_system.user.view;

import com.abc3355.abc_wms_system.Product.view.ProductView;
import com.abc3355.abc_wms_system.orderProcess.view.ManagerMenuView;
import com.abc3355.abc_wms_system.salesManager.View.SalesManagerView;
import com.abc3355.abc_wms_system.searchProduct.view.InventorySearchView;
import com.abc3355.abc_wms_system.searchProduct.view.SearchMenuView;
import com.abc3355.abc_wms_system.user.controller.AddUserController;
import com.abc3355.abc_wms_system.user.controller.LoginController;
import com.abc3355.abc_wms_system.user.model.dto.UserAndWarehouseDTO;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;

import java.io.IOException;
import java.util.*;

public class LoginView {

    public static UserDTO user;
    private static Map<String, String> loginMatch;
    private UserAndWarehouseDTO newUserAndWarehouse;
    private UserAndWarehouseDTO deleteUserAndWarehouse;

    /*Controller선언 부분*/
    private LoginController loginController = new LoginController();
    private AddUserController addUserController = new AddUserController();
    private ManagerMenuView managerMenuView = new ManagerMenuView();
    private ProductView productView = new ProductView();


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
                    loginMatch = headLoginFirstMenu();
                    user = loginController.headLoginSecondMenu(loginMatch);
                    if (user != null && user.getUserType().equals("head")) {
                        System.out.println("본사 로그인 성공");
                        headMainMenu();
                    } else {
                        System.out.println("본사 로그인 실패");
                    }
                    break;
                case 2:
                    loginMatch = branchLoginFirstMenu();
                    user = loginController.branchLoginSecondMenu(loginMatch);
                    if (user != null && user.getUserType().equals("branch")) {
                        System.out.println("가맹점 로그인 성공");
                        branchMainMenu(user.getUserId());
                    } else {
                        System.out.println("가맹점 로그인 실패");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        } while (true);
    }

    /* 본사 로그인 화면 */
    private Map<String, String> headLoginFirstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("본사 로그인");
        System.out.print("ID: ");
        String userId = sc.nextLine();
        System.out.print("PW: ");
        String userPassword = sc.nextLine();
        Map<String, String> loginMatch = new HashMap<>();
        loginMatch.put("userId", userId);
        loginMatch.put("userPassword", userPassword);
        return loginMatch;
    }

    /* 가맹점 로그인 화면 */
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

    /* 본사 메뉴 */
    private void headMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("< 본사 > 메뉴");
        while (true){
            System.out.println("1. 주문관리");
            System.out.println("2. 재고조회");
            System.out.println("3. 상품관리");
            System.out.println("4. 매출관리");
            System.out.println("5. 가맹점관리");
            System.out.println("0. 로그아웃");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1: managerMenuView.mainMenu(); break;
                case 2: new InventorySearchView().searchMenu(); break;
                case 3:
                    try {
                        productView.mainMenu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4: SalesManagerView.SalesManagerMain(); break;
                case 5: branchControl(); break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    /* 가맹점 메뉴 */
    private void branchMainMenu(String whId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("< " + whId + " 지점> 메뉴");
        while (true){
            System.out.println("1. 상품조회");
            System.out.println("2. 주문서 작성");
            System.out.println("3. 재고 조회");
            System.out.println("0. 로그아웃");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1: new SearchMenuView().searchMenu(); break;
                case 2: break;
                case 3: new InventorySearchView().searchMenu(); break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    /* 가맹점 추가 기능 */
    private UserAndWarehouseDTO inputBranch() {
        Scanner sc = new Scanner(System.in);
        UserAndWarehouseDTO userAndWarehouse = new UserAndWarehouseDTO();
        System.out.println("현재 등록된 가맹점");
        addUserController.showAllBranch();
        System.out.println("추가할 가맹점 정보를 입력하세요.");
        System.out.print("가맹점 ID: ");
        userAndWarehouse.setUserId(sc.nextLine());
        System.out.print("가맹점 Password: ");
        userAndWarehouse.setUserPassword(sc.nextLine());
        System.out.print("지점 종류: ");
        userAndWarehouse.setUserType(sc.nextLine());
        System.out.println("창고 정보를 입력하세요.");
        System.out.print("창고 이름: ");
        userAndWarehouse.setWhName(sc.nextLine());
        System.out.print("창고 주소: ");
        userAndWarehouse.setWhAddress(sc.nextLine());

        return userAndWarehouse;
    }


    /* 가맹점 관리 메소드 */
    private void branchControl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 가맹점 조회");
        System.out.println("2. 가맹점 추가");
        System.out.println("3. 가맹점 삭제");
        System.out.println("0. 이전 메뉴");
        System.out.print("관리할 메뉴 선택: ");
        int num = sc.nextInt();
        sc.nextLine();

        switch (num){
            case 1: addUserController.showAllBranch();
            case 2:
                newUserAndWarehouse = inputBranch();
                addUserController.createNewBranch(newUserAndWarehouse);
                break;
            case 3: addUserController.deleteBranch(deleteBranch());
            case 0:
                return;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    private Map<String, String> deleteBranch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 등록된 가맹점");
        addUserController.showAllBranch();
        System.out.print("삭제할 가맹점 번호: ");
        String no = sc.nextLine();

        Map<String, String> delete = new HashMap<>();
        delete.put("no", no);

        return delete;
    }
}
