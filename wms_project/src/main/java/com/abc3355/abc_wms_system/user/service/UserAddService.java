package com.abc3355.abc_wms_system.user.service;

import com.abc3355.abc_wms_system.user.model.dao.UserInsert.AddUserMapper;
import com.abc3355.abc_wms_system.user.model.dto.UserAndWarehouseDTO;
import com.abc3355.abc_wms_system.user.model.dto.WarehouseInfoDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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

    public List<WarehouseInfoDTO> findAll() {
        SqlSession sqlSession = getSqlSession();
        AddUserMapper addUserMapper = sqlSession.getMapper(AddUserMapper.class);
        List<WarehouseInfoDTO> list = addUserMapper.findAll();
        sqlSession.close();
        return list;
    }

    public boolean deleteBranch(int no) {
        SqlSession sqlSession = getSqlSession();
        AddUserMapper addUserMapper = sqlSession.getMapper(AddUserMapper.class);
        int result = addUserMapper.deleteUser(no);


        if(result>0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true:false;
    }
    }

