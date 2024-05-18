package com.abc3355.abc_wms_system.user.service;

import com.abc3355.abc_wms_system.user.model.dao.UserInsert.LoginMapper;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class loginService {
    private LoginMapper loginMapper;

    public List<UserDTO> selectAllUser(){
        SqlSession sqlSession = getSqlSession();

        loginMapper = sqlSession.getMapper(LoginMapper.class);
        List<UserDTO> userDTOList = loginMapper.selectAllUser();

        sqlSession.close();
        return userDTOList;
    }
}
