package com.hello.tms.mock.dao.mapper;

import com.hello.tms.mock.model.AcUser;

import java.util.List;

public interface AcUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(AcUser record);

    int insertSelective(AcUser record);

    AcUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(AcUser record);

    int updateByPrimaryKey(AcUser record);

    List<AcUser> selectAllUser();
}