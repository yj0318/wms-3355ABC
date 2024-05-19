package com.abc3355.abc_wms_system.searchProduct.model.service;

import com.abc3355.abc_wms_system.searchProduct.model.dao.*;
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

    public List<SearchProductDTO> searchProductByColor(String colors) {
        SqlSession sqlSession = getSqlSession();
        ColorMapper colorMapper = sqlSession.getMapper(ColorMapper.class);
        List<SearchProductDTO> productList = colorMapper.searchProductByColor(colors);
        sqlSession.close();
        return productList;
    }

    public List<SearchProductDTO> searchZeroProduct() {
        SqlSession sqlSession = getSqlSession();
        ZeroProductMapper zeroProductMapper = sqlSession.getMapper(ZeroProductMapper.class);
        List<SearchProductDTO> zeroList = zeroProductMapper.searchZeroProduct();
        sqlSession.close();
        return zeroList;
    }

    public List<SearchProductDTO> searchProductName(String name) {
        SqlSession sqlSession = getSqlSession();
        NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);
        List<SearchProductDTO> nameList = nameMapper.searchByName(name);
        sqlSession.close();
        return nameList;
    }

    public List<SearchProductDTO> searchProductSize(int size) {
        SqlSession sqlSession = getSqlSession();
        SizeMapper sizeMapper = sqlSession.getMapper(SizeMapper.class);
        List<SearchProductDTO> sizeList = sizeMapper.searchBySize(size);
        sqlSession.close();
        return sizeList;
    }

    public List<SearchProductDTO> searchProductCategory(String category) {
        SqlSession sqlSession = getSqlSession();
        SearchMapper categoryMapper = sqlSession.getMapper(SearchMapper.class);
        List<SearchProductDTO> categoryList = categoryMapper.searchByCategory(category);
        sqlSession.close();
        return categoryList;
    }
}
