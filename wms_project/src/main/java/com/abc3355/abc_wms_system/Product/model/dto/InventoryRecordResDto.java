package com.abc3355.abc_wms_system.Product.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryRecordResDto {
    private int no;
    private LocalDateTime date;
    private int amount;
    private int productNo;
}
