package com.hello.tms.mock.service;

import com.hello.tms.mock.dao.LoginLogDao;
import com.hello.tms.mock.dao.UserDao;
import com.hello.tms.mock.model.LoginLog;
import com.hello.tms.mock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alp.zxy
 * @date 2019/3/30
 */
@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    @Autowired
    public UserDao setUserDao(UserDao userDao) {
        return this.userDao = userDao;
    }

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }


    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
