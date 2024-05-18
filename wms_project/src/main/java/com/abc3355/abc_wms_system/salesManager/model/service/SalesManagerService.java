package com.abc3355.abc_wms_system.salesManager.model.service;

import com.abc3355.abc_wms_system.salesManager.model.dao.SaleManagerSqlMapper;
import com.abc3355.abc_wms_system.salesManager.model.dto.BranchDTO;
import com.abc3355.abc_wms_system.salesManager.model.dto.OrderProductDTO;
import com.abc3355.abc_wms_system.salesManager.model.dto.SelectBranchAndDateDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;


public class SalesManagerService {
private SaleManagerSqlMapper mapper;

    public void selectByBranchAndDate(SelectBranchAndDateDTO selectDTO) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<OrderProductDTO> orderList = mapper.selectByBranchAndDate(selectDTO);

        if(orderList != null && orderList.size() > 0) {
            for(OrderProductDTO order : orderList){
                System.out.println(order);
            }
        } else {
            System.out.println("검색결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public List<BranchDTO> getAllBranch() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<BranchDTO> branchList = mapper.getAllBranch();
        sqlSession.close();

        return branchList;
    }
}
