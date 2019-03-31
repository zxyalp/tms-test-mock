package com.hello.tms.mock.dao.mapper;

import com.hello.tms.mock.model.OpUser;

public interface OpUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(OpUser record);

    int insertSelective(OpUser record);

    OpUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(OpUser record);

    int updateByPrimaryKey(OpUser record);
}