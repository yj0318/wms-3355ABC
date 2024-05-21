package com.abc3355.abc_wms_system.orderForm.model.service;

import com.abc3355.abc_wms_system.orderForm.model.dao.OrderFormMapper;
import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderFormService {
    private OrderFormMapper orderFormMapper;

    /**
     * 주문 리스트를 테이플에 저장하는 서비스
     */
    public int insertOrder(int userNo, int totalPriceResult, List<InputOrderDTO> detailList) {

        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        // 새로운 주문의 기본키를 저장할 객체 생성
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("totalPriceResult", totalPriceResult);

        // 주문 총액 삽입 후 자동 생성된 주문 번호를 paramMap에서 꺼내 사용
        int result1 = orderFormMapper.insertOrderTotalPrice(paramMap);
        BigInteger orderNoBigInt = (BigInteger) paramMap.get("orderNo");

        // BigInteger를 Integer로 변환
        int orderNo = orderNoBigInt.intValue();

        int result2 = 0;
        for(InputOrderDTO input : detailList){

            input.setOrderNo(orderNo);
            result2 = result2 + orderFormMapper.insertOrderDetails(input);
        }

        if (result1 > 0 && result2 == detailList.size()) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result1 > 0 && result2 == detailList.size() ? 1 : 0;

    }

    /* 재고 상품 리스트를 프린트 */
    public List<InventoryConditionDTO> printInvByProductName(String name) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        List<InventoryConditionDTO> list = orderFormMapper.inventoryOrderForm(name);

        sqlSession.close();
        return list;
    }

    public int getTotalOrderPrice(List<InputOrderDTO> list){
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int totalPrice = 0;
        for (InputOrderDTO input : list) {
            totalPrice = totalPrice + orderFormMapper.getTotalOrderPrice(input);
        }
        if (totalPrice > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return totalPrice;
    }

//    public int getLastOrderNo() {
//        SqlSession sqlSession = getSqlSession();
//        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
//
//        int getOrderNo = orderFormMapper.getLastOrderNo();
//
//        if (getOrderNo > 0) {
//            sqlSession.commit();
//        } else {
//            sqlSession.rollback();
//        }
//
//        sqlSession.close();
//        return getOrderNo;
//    }

    public int getMaxAmount(InputOrderDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        String amountStr = orderFormMapper.getMaxAmount(input);
        int getMaxAmount = 0;

        if (amountStr != null) {
            getMaxAmount = Integer.parseInt(amountStr);
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return getMaxAmount;
    }

    public int getProductNo(InputOrderDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int no = 0;
        String noStr = orderFormMapper.getProductNo(input);

        if (noStr != null) {
            no = Integer.parseInt(noStr);
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return no;
    }
    public String getProductNameByNo(int num) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        String noStr = orderFormMapper.getProductNameByNo(num);

        if (noStr != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return noStr;
    }
    public String getProductColorByNo(int num) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        String noStr = orderFormMapper.getProductColorByNo(num);

        if (noStr != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return noStr;
    }
    public String getProductSizeByNo(int num) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        String noStr = orderFormMapper.getProductSizeByNo(num);

        if (noStr != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return noStr;
    }
    public String getProductPriceByNo(int num) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        String noStr = orderFormMapper.getProductPriceByNo(num);

        if (noStr != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return noStr;
    }
}


