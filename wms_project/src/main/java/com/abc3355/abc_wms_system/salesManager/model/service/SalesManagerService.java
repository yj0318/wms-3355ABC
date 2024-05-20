package com.abc3355.abc_wms_system.salesManager.model.service;

import com.abc3355.abc_wms_system.salesManager.View.PrintResultView;
import com.abc3355.abc_wms_system.salesManager.model.dao.SaleManagerSqlMapper;
import com.abc3355.abc_wms_system.salesManager.model.dto.*;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;


public class SalesManagerService {

PrintResultView printResultView = new PrintResultView();
private SaleManagerSqlMapper mapper;

    public List<SelectBranchOrderDTO> selectByBranchAndDate(SelectBranchAndDateDTO selectDTO) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<SelectBranchOrderDTO> orderList = mapper.selectByBranchAndDate(selectDTO);

        if(orderList == null | orderList.size() <= 0) { System.out.println("검색결과가 존재하지 않습니다.");}
        sqlSession.close();
        return orderList;
    }

    public List<BranchDTO> getAllBranch() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<BranchDTO> branchList = mapper.getAllBranch();
        sqlSession.close();

        return branchList;
    }

    public List<OrderDTO> selectAllOrder() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<OrderDTO> orderList = mapper.selectAllOrder();

        if(orderList == null | orderList.size() <= 0) { System.out.println("검색결과가 존재하지 않습니다.");}

        sqlSession.close();
        return orderList;
    }

    public List<ProductDTO> getAllProduct() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<ProductDTO> productList = mapper.getAllProduct();

        if(productList == null | productList.size() <= 0) { System.out.println("검색결과가 존재하지 않습니다.");};

        sqlSession.close();
        return productList;
    }

    public List<SelectProductSaleDTO> selectProductSale(int no) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SaleManagerSqlMapper.class);

        List<SelectProductSaleDTO> productList = mapper.selectProductSale(no);

        if(productList == null | productList.size() <= 0) { System.out.println("검색결과가 존재하지 않습니다.");};

        sqlSession.close();
        return productList;
    }

}
