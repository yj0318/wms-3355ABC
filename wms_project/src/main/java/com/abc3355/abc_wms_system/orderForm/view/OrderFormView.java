package com.abc3355.abc_wms_system.orderForm.view;

import com.abc3355.abc_wms_system.orderForm.controller.OrderFormController;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import com.abc3355.abc_wms_system.orderForm.model.service.OrderFormService;

import java.util.*;


public class OrderFormView {
    private OrderFormController orderFormController = new OrderFormController();
    int totalPriceResult = 0;

    public void orderFormMain() {

        OrderFormService orderFormService = new OrderFormService();
        Scanner sc = new Scanner(System.in);

        List<InputOrderDTO> detailListResult = new ArrayList<>();

        while (true) {

            System.out.print("새 주문서를 작성하시겠습니까? (Y/N) : ");
            String no = sc.nextLine();
            int result = 0;

            if (no.toUpperCase().equals("Y")) {

                while (result == 0) {
                    Map<String, String> para = inputNewOrder();                                             // 주문 입력 :  name, productNo, amount 를 돌려줌
                    InputOrderDTO order = orderFormController.inputdetailList(para);    // order : productNo, productName, productPrice, color, size, productAmount, amount;
                    detailListResult.add(order);                                        // 하나의 상품 주문서를 리스트에 저장
                    totalPriceResult = orderFormService.getTotalOrderPrice(detailListResult);   // 현재 저장된 주문의 총 주문액

                    System.out.print("상품을 추가 주문하시겠습니까? (Y/N) : ");
                    String no2 = sc.nextLine();

                    if (no2.toUpperCase().equals("Y")) {           // 추가 주문 진행

                        System.out.println("추가 상품을 주문합니다.");

                    } else if (no2.toUpperCase().equals("N")) {

                        List<InputOrderDTO> temp= checkOrder(detailListResult);
                        detailListResult = temp;                                                          // 작성한 주문서를 확인 후 최종 주문리스트를 반환

                        if (temp.size() > 0) {
                            totalPriceResult = orderFormService.getTotalOrderPrice(detailListResult);         // 최종 주문서 기준 총 주문액
                            orderFormController.insertOrderAndDetailList(totalPriceResult, detailListResult); // 입력한 주문을 테이블에 INSERT
                            result = 1;
                        } else { result = 1; }
                    } else { System.out.println("잘못된 값입니다. 다시 입력해주세요."); }
                }
            } else if (no.toUpperCase().equals("N")) { System.out.println("주문서 작성을 종료합니다."); return;
            } else { System.out.println("잘못된 값입니다. 다시 입력해주세요."); }

            System.out.println("주문서 작성을 종료합니다. 감사합니다.");
            return;
            }
        }

    /**
     * 입력한 주문을 (수정/선택삭제/전체삭제/확정) 할지를 확인
     * @param :  productNo, productName, productPrice, color, size, productAmount, amount
     */
    public List<InputOrderDTO> checkOrder(List<InputOrderDTO> list) {

        PrintResult pr = new PrintResult();
        Scanner sc = new Scanner(System.in);
        List<InputOrderDTO> temp = new ArrayList<>();
        temp = list;

        while (true){
            pr.printOrder(totalPriceResult, temp);   // 주문 확인서 출력
            System.out.println("[최종 주문 메뉴]");
            System.out.println("1. 주문 확정");
            System.out.println("2. 주문 수량 변경");
            System.out.println("3. 선택 상품 삭제");
            System.out.println("4. 전체 주문 취소");
            String no = sc.nextLine();

            int result = 0;
            switch (no) {
                case "1": System.out.println("주문을 저장합니다."); result = 1 ;break;
//                case "2": temp = modifyOrderList(list); continue;
//                case "3": temp = deleteOneOrder(list); continue;
                case "4":
                    System.out.println("정말 주문을 취소 하시겠습니까? (Y/N)");
                    String no2 = sc.nextLine();
                    if(no2.toUpperCase().equals("Y")){
                        temp = null;
                        result = 4; break;
                    } else { System.out.println("다시 입력해주세요."); break; }
                default:
                    System.out.println("잘못된 값입니다. 다시 입력해주세요.");
            }
            if(result == 1 || result == 4) break;
        }
        return temp;

    }


    /**
     * 상품명(name), 상품번호(productNo), 수량(amount) 를 얻는 메서드
     * @return Map<String, String> parameter
     */
    public Map<String, String> inputNewOrder() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> parameter = new HashMap<>();

        System.out.println("==== 주문서 작성 ==================================================================================");

        // 1. 상품명 입력
        do {
            System.out.println("상품명을 입력하세요 : ");
            String name = sc.nextLine();
            parameter.put("name", name);

            if (orderFormController.printInvByProductName(name) == 0) {
                System.out.println("검색한 상품이 존재하지 않습니다. 다시 검색해주세요.");
            } else {
                break;
            }
        } while (true);


        // 2. 상품 번호 입력
        do {
            System.out.println("주문할 상품 번호를 입력하세요 :");
            String no = sc.nextLine().trim();
            parameter.put("productNo",no);

            if (orderFormController.checkNo(parameter) == 0) {
                System.out.println("선택한 상품 번호가 존재하지 않습니다. 다시 입력해주세요.");
            } else {
                parameter.put("productNo", no);
                break;
            }
        } while (true);



        // 3. 수량 입력
        do {
            System.out.println("수량을 입력하세요 :");
            String amount = sc.nextLine();
            parameter.put("amount", amount);

            int result = orderFormController.checkInvAmount(parameter);

            if (result == 0) {
                System.out.println("해당 수량은 주문 불가합니다. 다시 입력해주세요.");
            } else {
                break;
            }
        } while (true);


        return parameter;
    }
}