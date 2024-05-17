package com.abc3355.abc_wms_system.product.mapper;

import com.abc3355.abc_wms_system.Product.model.dto.InventoryReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.StoreStatusRecordResDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import com.abc3355.abc_wms_system.Product.model.service.InventoryServicePP;
import com.abc3355.abc_wms_system.Product.model.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    ProductService productService = new ProductService();
    InventoryServicePP inventoryServicePP = new InventoryServicePP();


    @Test
    public void saveTest(){
        // given
        ProductSaveReqDto productSaveReqDto = new ProductSaveReqDto("name", 100, "N", 1, 1, 1, 100, 1);

        // when
        int result = productService.saveProduct(productSaveReqDto);

        // then
        assertThat(result).isEqualTo(1);

    }

    @Test
    public void updateTest(){
        // given
        ProductUpdateReqDto productUpdateReqDto = new ProductUpdateReqDto("updatename", 1001, "Y", 1, 1, 1);

        // when
        int result = productService.updateProduct(8, productUpdateReqDto);

        // then
        assertThat(result).isEqualTo(1);

    }
    
    @Test
    public void deleteTest(){
        // given
        int productNo = 8;
        // when
        int result = productService.deleteProduct(8);
        // then
//        assertThat(result).isEqualTo(1);
//        assertThat(result).isEqualTo(0);

    }


    @Test
    public void getRecordList(){
        // given

        // when
        List<StoreStatusRecordResDto> receivingRecord = inventoryServicePP.getReceivingRecord();

        // then
        for (StoreStatusRecordResDto recordResDto : receivingRecord) {
            System.out.println(recordResDto.getNo());
            System.out.println(recordResDto.getAmount());
            System.out.println(recordResDto.getDate());
            System.out.println(recordResDto.getProductNo());
        }

        assertThat(receivingRecord.size()).isEqualTo(1);

    }

    @Test
    public void updateInventory(){
        // given
        InventoryReqDto inventoryReqDto = new InventoryReqDto(8, 1, 999);
        // when
        int result = inventoryServicePP.updateInventory(inventoryReqDto);

        // then
        assertThat(result).isEqualTo(1);

    }



}
