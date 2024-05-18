package com.abc3355.abc_wms_system.user.model.dao.UserInsert;

import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginMapper {
    @Results(id = "userResultMap", value = {
            @Result(id = true, property = "no", column = "USER_NO"),
            @Result(property = "id", column = "USER_ID"),
            @Result(property = "password", column = "USER_PASSWORD"),
            @Result(property = "type", column = "USER_TYPE"),
            @Result(property = "id", column = "WH_ID"),
    })
    @Select("SELECT\n" +
            "      user_no\n" +
            "    , user_id\n" +
            "    , user_password\n" +
            "    , user_type\n" +
            "    , wh_id\n" +
            "FROM\n" +
            "    TBL_MENU\n" +
            "WHERE orderable_status = 'Y'\n" +
            "ORDER BY  menu_code")
    List<UserDTO> selectAllUser();
}
