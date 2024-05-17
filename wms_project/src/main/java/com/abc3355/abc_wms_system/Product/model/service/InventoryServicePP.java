package com.abc3355.abc_wms_system.Product.model.service;

import com.abc3355.abc_wms_system.Product.model.dao.InventoryMapperPP;
import com.abc3355.abc_wms_system.Product.model.dao.StoreStatusMapper;
import com.abc3355.abc_wms_system.Product.model.dto.StoreStatusRecordResDto;
import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class InventoryServicePP {

    /**
     * 재고 등록
     */
    public int updateInventory(InventoryReqDto inventoryReqDto) {
        SqlSession sqlSession = getSqlSession();

        InventoryMapperPP inventoryMapperPP = sqlSession.getMapper(InventoryMapperPP.class);
        StoreStatusMapper storeStatusMapper = sqlSession.getMapper(StoreStatusMapper.class);

        try{
            //재고 확인
            int productAmt = inventoryMapperPP.getProductAmt(inventoryReqDto.getProductNo());

            //기록 저장
            storeStatusMapper.saveRecordByUpdateInventory(inventoryReqDto);

            //재고 수정
            inventoryReqDto.addAmount(productAmt);
            int result = inventoryMapperPP.updateInventory(inventoryReqDto);

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
     * 입고 내역 조회
     */
    public List<StoreStatusRecordResDto> getReceivingRecord(){
        SqlSession sqlSession = getSqlSession();

        StoreStatusMapper storeStatusMapper = sqlSession.getMapper(StoreStatusMapper.class);

        return storeStatusMapper.getReceivingRecord();
    }


}
