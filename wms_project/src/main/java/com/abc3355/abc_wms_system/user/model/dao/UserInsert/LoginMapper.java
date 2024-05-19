package com.abc3355.abc_wms_system.user.model.dao.UserInsert;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginMapper {
    UserDTO getUserMatch(String userId, String userPassword);
}
