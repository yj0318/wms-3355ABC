package com.abc3355.abc_wms_system.searchProduct.model.service;

import com.abc3355.abc_wms_system.searchProduct.model.dao.InvSearchMapper;
import com.abc3355.abc_wms_system.searchProduct.model.dao.ProductSearchMapper;
import com.abc3355.abc_wms_system.searchProduct.model.dto.InventorySearchDTO;
import com.abc3355.abc_wms_system.searchProduct.model.dto.ProductSearchDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class SearchService {

    public List<ProductSearchDTO> searchAllProduct() {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> list = productSearchMapper.searchAllProduct();
        sqlSession.close();
        return list;
    }

    public List<ProductSearchDTO> searchProductByColor(String colors) {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> productList = productSearchMapper.searchProductByColor(colors);
        sqlSession.close();
        return productList;
    }

    public List<ProductSearchDTO> searchZeroProduct() {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> zeroList = productSearchMapper.searchZeroProduct();
        sqlSession.close();
        return zeroList;
    }

    public List<ProductSearchDTO> searchProductName(String name) {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> nameList = productSearchMapper.searchByName(name);
        sqlSession.close();
        return nameList;
    }

    public List<ProductSearchDTO> searchProductSize(int size) {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> sizeList = productSearchMapper.searchBySize(size);
        sqlSession.close();
        return sizeList;
    }

    public List<ProductSearchDTO> searchProductCategory(String category) {
        SqlSession sqlSession = getSqlSession();
        ProductSearchMapper productSearchMapper = sqlSession.getMapper(ProductSearchMapper.class);
        List<ProductSearchDTO> categoryList = productSearchMapper.searchByCategory(category);
        sqlSession.close();
        return categoryList;
    }

    public List<InventorySearchDTO> searchAllInventory(int user) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> list = invSearchMapper.showAllInventory(user);
        sqlSession.close();
        return list;
    }

    public List<InventorySearchDTO> searchInvenByColor(int user,String color) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> colors = invSearchMapper.searchInvenByColor(user, color);
        sqlSession.close();
        return colors;
    }

    public List<InventorySearchDTO> searchZeroInventory(int user) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> zero = invSearchMapper.searchZeroInventory(user);
        sqlSession.close();
        return zero;
    }

    public List<InventorySearchDTO> searchInventoryName(int user, String name) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> names = invSearchMapper.searchInventoryName(user,name);
        sqlSession.close();
        return names;
    }

    public List<InventorySearchDTO> searchInvenBySize(int user, int size) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> siezs = invSearchMapper.searchInventorySize(user, size);
        sqlSession.close();
        return siezs;
    }

    public List<InventorySearchDTO> searchInvenByCategory(int user, String category) {
        SqlSession sqlSession = getSqlSession();
        InvSearchMapper invSearchMapper = sqlSession.getMapper(InvSearchMapper.class);
        List<InventorySearchDTO> categorys = invSearchMapper.searchInventoryCategory(user, category);
        sqlSession.close();
        return categorys;
    }
}
