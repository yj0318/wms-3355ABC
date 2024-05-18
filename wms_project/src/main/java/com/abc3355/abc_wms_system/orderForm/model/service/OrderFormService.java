package com.abc3355.abc_wms_system.orderForm.model.service;

import com.abc3355.abc_wms_system.orderForm.model.dao.OrderFormMapper;
import com.abc3355.abc_wms_system.orderForm.model.dto.BranchOrderFormDTO;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class OrderFormService {
    public int insertOrderFrom(BranchOrderFormDTO branchOrderFormDTO) {

        SqlSession sqlSession = getSqlSession();
        OrderFormMapper orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
        int result = orderFormMapper.insertOrderForm(branchOrderFormDTO);
        sqlSession.commit();
        sqlSession.close();
        return result;

    }
}
