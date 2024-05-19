package com.abc3355.abc_wms_system.Product.model.service;

import com.abc3355.abc_wms_system.Product.model.dao.InventoryMapperPP;
import com.abc3355.abc_wms_system.Product.model.dao.ProductMapper;
import com.abc3355.abc_wms_system.Product.model.dao.StoreStatusMapper;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class ProductService {

    /**
     * 신상품 등록
     */
    public int saveProduct(ProductSaveReqDto productSaveReqDto) {
        SqlSession sqlSession = getSqlSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        InventoryMapperPP inventoryMapperPP = sqlSession.getMapper(InventoryMapperPP.class);
        StoreStatusMapper storeStatusMapper = sqlSession.getMapper(StoreStatusMapper.class);

        try{
            // 상품 저장
            productMapper.saveProduct(productSaveReqDto);

            // 재고 저장
            inventoryMapperPP.saveInventoryByNewProduct(productSaveReqDto);

            // 창고 입고 기록 저장
            storeStatusMapper.saveRecordByNewProduct(productSaveReqDto);

            sqlSession.commit();
            return productSaveReqDto.getProductNo();
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

    /**
     * 기존 상품 수정
     */
    public int updateProduct(ProductUpdateReqDto productUpdateReqDto) {
        SqlSession sqlSession = getSqlSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        try{
            int result = productMapper.updateProduct(productUpdateReqDto);

            sqlSession.commit();
            return result;
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 기존 상품 삭제
     */
    public int deleteProduct(int productNo){
        SqlSession sqlSession = getSqlSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        InventoryMapperPP inventoryMapperPP = sqlSession.getMapper(InventoryMapperPP.class);
        StoreStatusMapper storeStatusMapper = sqlSession.getMapper(StoreStatusMapper.class);

        try{
            //재고 확인
            int productAmt = inventoryMapperPP.getProductAmt(productNo);
            System.out.println("productAmt = " + productAmt);

            if(productAmt == 0){
                storeStatusMapper.deleteStoreStatus(productNo);
                inventoryMapperPP.deleteInventory(productNo);
                int result = productMapper.deleteProduct(productNo);


                sqlSession.commit();
                return result;
            }
            sqlSession.commit();
            return 0;
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }





}
