package com.abc3355.abc_wms_system.salesManager.model.dto;

import lombok.*;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
public class SelectBranchOrderDTO {

        private int orderNo;
        private int userNO;
        private String userName;
        private int orderPrice;
        private String orderStatusName;
        private String orderDetail;
        private java.sql.Date orderDate;
}
