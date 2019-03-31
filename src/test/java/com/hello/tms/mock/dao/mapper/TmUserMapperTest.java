package com.hello.tms.mock.dao.mapper;

import com.hello.tms.mock.model.TmUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TmUserMapperTest {

    @Autowired
    private TmUserMapper tmUserMapper;

    @Test
    public void testInsert(){
        TmUser tmUser = new TmUser();
        tmUser.setUserName("李浩然2222");
        tmUser.setPassword("123123");
        tmUser.setPhone("1380000000");
        tmUserMapper.insert(tmUser);
    }

    @Test
    public void testQuery(){
        List<TmUser> tmUsers = tmUserMapper.getAll();
        System.out.println(tmUsers.toString());
    }


}
