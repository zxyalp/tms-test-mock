package com.hello.tms.mock.service;

import com.github.pagehelper.PageInfo;
import com.hello.tms.mock.model.BpUser;

/**
 * @author alp.zxy
 * @date 2019/3/31
 */
public interface BpUserService {
    int addUser(BpUser user);

    PageInfo<BpUser> findAllUser(int pageNum, int pageSize);
}
