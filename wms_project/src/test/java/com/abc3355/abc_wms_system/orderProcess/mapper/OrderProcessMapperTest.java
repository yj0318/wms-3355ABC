//package com.abc3355.abc_wms_system.orderProcess.mapper;
//
//import com.abc3355.abc_wms_system.orderProcess.model.dto.OrderUpdateReqDTO;
//import com.abc3355.abc_wms_system.orderProcess.model.service.OrderProcessService;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class OrderProcessMapperTest {
//
//    OrderProcessService orderProcessService = new OrderProcessService();
//
//    @Test
//    public void orderCancelTest() {
//        // given
//        OrderUpdateReqDTO orderUpdateReqDTO = new OrderUpdateReqDTO(1);
//        // when
//        boolean result = orderProcessService.cancelOrderTest(orderUpdateReqDTO);
//        // then
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    public void orderShippingTest() {
//        OrderUpdateReqDTO orderUpdateReqDTO = new OrderUpdateReqDTO(1);
//
//    }
//
//    @Test
//    public void orderConfirmTest() {
//        // given
//        OrderUpdateReqDTO orderUpdateReqDTO = new OrderUpdateReqDTO(3);
//        // when
//        boolean result = orderProcessService.confirmOrderTest(orderUpdateReqDTO);
//        // then
//        assertThat(result).isTrue();
//    }
//
//}
