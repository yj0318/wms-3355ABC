package com.abc3355.abc_wms_system.orderForm.model.service;

import com.abc3355.abc_wms_system.orderForm.model.dao.OrderFormMapper;
import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.ProductInputDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

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

    public int getProductNo(ProductInputDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int getProductNo = orderFormMapper.getProductNo(input);

        if (getProductNo > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return getProductNo;
    }

    public int getMaxAmount(ProductInputDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int getMaxAmount = orderFormMapper.getMaxAmount(input);

        if (getMaxAmount > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return getMaxAmount;
    }
}


