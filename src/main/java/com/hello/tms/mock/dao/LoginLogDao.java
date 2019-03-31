package com.hello.tms.mock.dao;

import com.hello.tms.mock.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * @author alp.zxy
 * @date 2019/3/30
 */
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_LOGIN_LOG_SQL = "INSERT INTO t_login_log(user_id, ip, login_datetime) "+
            " VALUES(?, ? ,?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog){
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }
}
