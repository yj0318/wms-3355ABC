package com.abc3355.abc_wms_system.searchProduct.model.service;

import com.abc3355.abc_wms_system.searchProduct.model.dao.ColorMapper;
import com.abc3355.abc_wms_system.searchProduct.model.dao.SearchMapper;
import com.abc3355.abc_wms_system.searchProduct.model.dto.SearchProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class SearchService {

    public List<SearchProductDTO> searchAllProduct() {
        SqlSession sqlSession = getSqlSession();
        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);
        List<SearchProductDTO> list = searchMapper.searchAllProduct();
        sqlSession.close();
        return list;
    }

    public List<SearchProductDTO> searchProductByColor(int colors) {
        SqlSession sqlSession = getSqlSession();
        ColorMapper colorMapper = sqlSession.getMapper(ColorMapper.class);
        List<SearchProductDTO> productList = colorMapper.searchProductByColor(colors);
        sqlSession.close();
        return productList;
    }

}
