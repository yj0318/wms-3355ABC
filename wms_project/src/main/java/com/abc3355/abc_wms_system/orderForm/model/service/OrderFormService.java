package com.abc3355.abc_wms_system.orderForm.model.service;

import com.abc3355.abc_wms_system.orderForm.model.dao.OrderFormMapper;
import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderFormService {

    private OrderFormMapper orderFormMapper;

    public Boolean insertOrderProduct(InsertNoAndAmountDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int result = orderFormMapper.insertOrderProduct(input);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;

    }

    public Boolean insertOrderDetail(InsertNoAndAmountDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int result = orderFormMapper.insertOrderDetail(input);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;

    }

    public int getTotalOrderPrice(InsertNoAndAmountDTO input){
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int totalOrderPrice = orderFormMapper.getTotalOrderPrice(input);

        if (totalOrderPrice > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return totalOrderPrice;
    }


    public int getLastOrderNo() {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int getOrderNo = orderFormMapper.getLastOrderNo();

        if (getOrderNo > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return getOrderNo;
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

    public List<InventoryConditionDTO> printInvByProductName(String name) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        List<InventoryConditionDTO> list = orderFormMapper.inventoryOrderForm(name);

        sqlSession.close();
        return list;
    }
}


