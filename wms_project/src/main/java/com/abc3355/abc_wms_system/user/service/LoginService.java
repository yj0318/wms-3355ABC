package com.abc3355.abc_wms_system.user.service;

import com.abc3355.abc_wms_system.user.model.dao.UserInsert.LoginMapper;
import com.abc3355.abc_wms_system.user.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class LoginService {
    private LoginMapper loginMapper;
        public UserDTO loginService(String userId, String userPassword) {
            try (SqlSession sqlSession = getSqlSession()) {
                LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
                return loginMapper.getUserMatch(userId, userPassword);
            }
    }

    public UserDTO loginServiceHead(String userId, String userPassword) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            return loginMapper.getUserMatchHead(userId, userPassword);
        }
    }
}
