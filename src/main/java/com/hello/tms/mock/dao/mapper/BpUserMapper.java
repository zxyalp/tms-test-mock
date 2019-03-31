package com.hello.tms.mock.dao.mapper;

import com.hello.tms.mock.model.BpUser;

import java.util.List;

/**
 * @author alp.zxy
 * @date 2019/3/30
 */
public interface BpUserMapper {

    int insert(BpUser bpUser);

    List<BpUser> selectUsers();

}
