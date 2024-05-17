package com.abc3355.abc_wms_system.Product.model.service;

import com.abc3355.abc_wms_system.Product.model.dao.ProductMapper;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class ProductService {

    public int selectAll() {
        SqlSession sqlSession = getSqlSession();

        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        int i = mapper.selectAll();

        return i;
    }


}
