package com.abc3355.abc_wms_system.Product.model.service;

import com.abc3355.abc_wms_system.Product.model.dao.ProductMapper;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class ProductService {

    /**
     * 신상품 등록
     */
    public int saveProduct(ProductSaveReqDto productSaveReqDto) {
        SqlSession sqlSession = getSqlSession();

        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        // 상품정보
        int result = mapper.saveProduct(productSaveReqDto);

        System.out.println("id : " + productSaveReqDto.getProductNo());
        int productNo = productSaveReqDto.getProductNo();
        // 창ㅑ

        // 창고 입고 기록


        return result;
    }

    /**
     * 기존 상품 수정
     */
    public int updateProduct(int productNo, ProductUpdateReqDto productUpdateReqDto) {

        return 1;
    }

    /**
     * 기존 상품 삭제
     */
    public int deleteProduct(int productNo){

        return 1;
    }


    /**
     * test
     * @return
     */
    public int selectAll() {
        SqlSession sqlSession = getSqlSession();

        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        int i = mapper.selectAll();

        return i;
    }


}
