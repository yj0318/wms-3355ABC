package com.abc3355.abc_wms_system.orderForm.model.dao;

import com.abc3355.abc_wms_system.orderForm.model.dto.InsertNoAndAmountDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InventoryConditionDTO;
import com.abc3355.abc_wms_system.orderForm.model.dto.InputOrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderFormMapper {
    int insertOrderTotalPrice(Map<String, Object> paramMap);
    List<InventoryConditionDTO> inventoryOrderForm(String name);
    int getTotalOrderPrice(InputOrderDTO input);
//    int getLastOrderNo();
    String getProductNo(InputOrderDTO input);

    String getMaxAmount(InputOrderDTO input);


    String getProductNameByNo(int num);

    String getProductColorByNo(int num);

    String getProductSizeByNo(int num);

    String getProductPriceByNo(int num);


    int insertOrderDetails(InputOrderDTO input);


}
