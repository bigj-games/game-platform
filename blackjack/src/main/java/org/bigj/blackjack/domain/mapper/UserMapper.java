package org.bigj.blackjack.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.bigj.blackjack.domain.entity.User;

/**
 * Created by arthan on 02.10.2016. | Project game-platform
 */

public interface UserMapper {

    @Select("SELECT username, password " +
            "FROM users " +
            "WHERE username=#{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users(username, password) " +
            "VALUES (#{username}, #{password})")
    @Options(keyColumn = "username", keyProperty = "username")
    void createUser(User user);
}
