package com.abc3355.abc_wms_system.user.service;

import com.abc3355.abc_wms_system.user.model.dao.UserInsert.AddUserMapper;
import com.abc3355.abc_wms_system.user.model.dto.UserAndWarehouseDTO;
import org.apache.ibatis.session.SqlSession;

import static com.abc3355.abc_wms_system.common.MyBatisTemplate.getSqlSession;

public class UserAddService {
    public void createNewBranch(UserAndWarehouseDTO userAndWarehouse) {
        SqlSession sqlSession = getSqlSession();
        AddUserMapper addUserMapper = sqlSession.getMapper(AddUserMapper.class);
        try {
            addUserMapper.insertWarehouse(userAndWarehouse);
            sqlSession.commit();

            int whId = userAndWarehouse.getWhId();
            userAndWarehouse.setWhId(whId);

            addUserMapper.insertUser(userAndWarehouse);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
