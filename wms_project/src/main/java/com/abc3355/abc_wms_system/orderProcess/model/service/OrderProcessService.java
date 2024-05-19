package com.abc3355.abc_wms_system.orderProcess.model.service;

import com.abc3355.abc_wms_system.orderProcess.model.dao.OrderProcessMapper;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderDetailResDTO;
import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderListResDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderProcessService {
    public List<OrderListResDTO> searchAllOrders() {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectAllOrders();
        sqlSession.close();
        return orderList;
    }

    public List<OrderListResDTO> searchOrdersByName(String name) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectOrdersByName(name);
        sqlSession.close();
        return orderList;
    }

    public List<OrderListResDTO> searchOrdersByStatus(String status) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectOrdersByStatus(status);
        sqlSession.close();
        return orderList;
    }

    public List<OrderListResDTO> searchMyOrders(String userId) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectMyOrders(userId);
        sqlSession.close();
        return orderList;
    }

    public List<OrderListResDTO> searchMyOrdersByStatus(String userId, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("status", status);
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderListResDTO> orderList = mapper.selectMyOrdersByStatus(map);
        sqlSession.close();
        return orderList;
    }

    public List<OrderDetailResDTO> searchOrderDetails(int orderNo) {
        SqlSession sqlSession = getSqlSession();
        OrderProcessMapper mapper = sqlSession.getMapper(OrderProcessMapper.class);
        List<OrderDetailResDTO> orderDetailList = mapper.selectOrderDetails(orderNo);
        sqlSession.close();
        return orderDetailList;
    }
}