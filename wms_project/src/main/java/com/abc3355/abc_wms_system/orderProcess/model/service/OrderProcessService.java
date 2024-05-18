package com.abc3355.abc_wms_system.orderProcess.model.service;

import com.abc3355.abc_wms_system.orderProcess.model.dao.OrderProcessMapper;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderProcessService {
    public static List<OrderListResDTO> searchAllOrders() {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectAllOrders();
        sqlSession.close();
        return orderList;
    }
    public static List<OrderListResDTO> searchOrdersByName(String name) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectOrdersByName(name);
        sqlSession.close();
        return orderList;
    }
    public static List<OrderListResDTO> searchOrdersByStatus(String status) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectOrdersByStatus(status);
        sqlSession.close();
        return orderList;
    }
}
