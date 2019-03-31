package com.hello.tms.mock.dao.mapper;

import com.hello.tms.mock.model.TmUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alp.zxy
 * @date 2019/3/31
 */
public interface TmUserMapper {

    @Select("SELECT * FROM qa_user")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name")})
    List<TmUser> getAll();

    @Select("SELECT * FROM qa_user WHERE userId=#{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name")})
    TmUser getOne(@Param("user_id") int userId);

    @Insert("INSERT INTO qa_user(user_name, password, phone)VALUES(#{userName}, #{password}, #{phone})")
    void insert(TmUser tmUser);

    @Update("UPDATE qa_user SET user_name=#{username}, password=#{password}, phone=#{phone} WHERE user_id=#{userId}")
    void update(TmUser tmUser);

    @Delete("DELETE FROM qa_user WHERE user_id=#{userId}")
    void delete(@Param("userId") int userId);
}
