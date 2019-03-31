package com.hello.tms.mock.dao;


import com.hello.tms.mock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author alp.zxy
 * @date 2019/3/30
 */

@Repository
public class UserDao {

    private  final static String MATCH_COUNT_SQL = " SELECT count(*) FROM " +
            " t_user WHERE user_name=? and password=? ";

    private final static String SELECT_USER_SQL = " SELECT user_id, user_name, credits "+
            " FROM t_user WHERE user_name=? ";

    private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?, last_ip=?, credits=? WHERE user_id=? ";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }


    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(SELECT_USER_SQL, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(),user.getLastIp(),
                user.getCredits(), user.getUserId()});
    }



}
