package com.abc3355.abc_wms_system.orderForm.model.dto;
import lombok.*;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrderAllInfoDTO {

    private int  order_no;
    private int user_no;
    private int order_price;
    private int order_status_no;
    private String order_detail;
    private String order_date;
    private int od_no;
    private int od_amount;
    private int product_no;
    private String product_name;

}
