package com.abc3355.abc_wms_system.product.mapper;

import com.abc3355.abc_wms_system.Product.model.dto.ProductSaveReqDto;
import com.abc3355.abc_wms_system.Product.model.dto.ProductUpdateReqDto;
import com.abc3355.abc_wms_system.Product.model.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    ProductService productService = new ProductService();
    

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
        int result = productService.deleteProduct(7);
        // then
        assertThat(result).isEqualTo(1);
        
    }


}
