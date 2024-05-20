package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputDataDTO;

import java.util.*;

import static com.abc3355.abc_wms_system.user.view.LoginView.user;


public class OrderFormView{
    private OrderFormController orderFormController = new OrderFormController();
    Scanner sc = new Scanner(System.in);


    public void orderFormMain() {

        do {
            System.out.print("주문하시겠습니까(Y/N) ? ");
            String input = sc.nextLine();

            if (input.toUpperCase().equals("Y")) {
                orderFormController.insertOrderByNo(newOrderByNo()); //상품번호,수량를 입력받습니다.
            } else {
                System.out.println("주문신청이 취소되었습니다.");
            }
        } while (true);
    }


    private Map<String, String> newOrderByNo() {
        Scanner sc = new Scanner(System.in);
        List<InputDataDTO> inputList = new ArrayList<>();
        InputDataDTO input = new InputDataDTO();

        System.out.println("=====================");
        System.out.println("[주문서를 작성합니다.]");
        System.out.println("=====================");

        do {
            System.out.println("상품명을 입력하세요 : ");
            String name = sc.nextLine();
            input.setName(name);
            /* 민규님, 검색한 정보에 맞는 상세 정보(상품명, 단가, 재고수량, 옵션) 출력해주세요. */
            String print = orderFormController.printInvByProductName(name);
            if(print == null){
                System.out.println("검색한 상품이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                break;
            }

        } while (true);

        System.out.println("색상과 사이즈를 입력하세요(예: RED, 230) :");
        String[] strArr = (sc.nextLine()).split(", ");

        /* 입력한 옵션 값이 정상적인지 확인 */

        input.setColor(strArr[0]);
        input.setSize(strArr[1]);


        int noInt = getProductNo(input);   // 민규님, [(type InputDataDTO) name,color,size] 드릴테니 int no를 돌려주세요.
        String no = String.valueOf(noInt);

        do {
            System.out.println("수량을 입력하세요 :");
            String amount = sc.nextLine();

            /* 민규님, 수량을 줄테니 재고랑 비교해서 '참이면 1, 거짓이면 0' 돌려주세요. */
            int result = checkInvAmount(amount);

            if (result == 0) {
                System.out.println("해당 수량은 주문 불가합니다. 다시 입력해주세요.");
            } else {
                break;
            }
        } while (true);
        Map<String,String> parameter = new HashMap<>();
        parameter.put("no", no);
        parameter.put("amount",amount);
        parameter.put("user", user.getUserId());
        return parameter;
    }

}