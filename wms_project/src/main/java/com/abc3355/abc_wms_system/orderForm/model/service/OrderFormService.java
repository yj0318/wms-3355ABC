package com.abc3355.abc_wms_system.orderForm.model.service;

import com.abc3355.abc_wms_system.orderForm.model.dao.OrderFormMapper;
import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderFormService {

    private OrderFormMapper orderFormMapper;

    public Boolean insertOrderByTotalPrice(int totalOrderPrice) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int result = orderFormMapper.insertOrderByTotalPrice(totalOrderPrice);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;

    }

    public Boolean insertOrderDetailAmount(InsertNoAndAmountDTO input) {
        SqlSession sqlSession = getSqlSession();
        orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);

        int result = orderFormMapper.insertOrderDetailAmount(input);

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

    }


