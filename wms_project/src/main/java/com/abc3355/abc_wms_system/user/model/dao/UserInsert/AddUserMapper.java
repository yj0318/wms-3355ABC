package com.abc3355.abc_wms_system.user.model.dao.UserInsert;

import com.abc3355.abc_wms_system.user.model.dto.UserAndWarehouseDTO;

public interface AddUserMapper {
    void insertWarehouse(UserAndWarehouseDTO userAndWarehouse);

    void insertUser(UserAndWarehouseDTO userAndWarehouse);
}
