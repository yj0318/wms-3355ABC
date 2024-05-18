package com.abc3355.abc_wms_system.user.run;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import com.abc3355.abc_wms_system.user.view.LoginView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("1. 본사");
            System.out.println("2. 가맹점");
            System.out.println("0. 종료하기");
            System.out.print("해당하는 계정을 선택하세요: ");
            int no = sc.nextInt();
            switch(no) {
                case 1 : headQuartersLogin(); break;
                case 2 : branchLogin(); break;
                case 9 : System.out.println("프로그램을 종료합니다."); return;
            }
        } while(true);
    }

    private static void branchLogin() {
        LoginView loginView = new LoginView();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("==== 가맹점 로그인 ====");
            System.out.print("ID: ");
            String userId = sc.nextLine();
            System.out.print("PW: ");
            String userPassword = sc.nextLine();
            loginView.branchLoginMenu(userId, userPassword);
        } while (true);
    }

    private static void headQuartersLogin() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("==== 본사 로그인 ====");
            System.out.print("ID: ");
            String userId = sc.nextLine();
            System.out.print("PW: ");
            String userPassword = sc.nextLine();
        } while(true);
    }

}
