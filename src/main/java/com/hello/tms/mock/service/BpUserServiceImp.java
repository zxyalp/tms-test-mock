package com.hello.tms.mock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.tms.mock.dao.mapper.BpUserMapper;
import com.hello.tms.mock.model.BpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alp.zxy
 * @date 2019/3/31
 */
@Service("bpUserService")
public class BpUserServiceImp implements BpUserService{

    @Autowired
    private BpUserMapper bpUserMapper;

    @Override
    public int addUser(BpUser user) {
        return bpUserMapper.insert(user);
    }

    @Override
    public PageInfo<BpUser> findAllUser(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<BpUser> bpUsers = bpUserMapper.selectUsers();
        PageInfo rs = new PageInfo(bpUsers);
        return rs;
    }
}
