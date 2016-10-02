package org.bigj.blackjack.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.bigj.blackjack.domain.entity.User;

/**
 * Created by arthan on 02.10.2016. | Project game-platform
 */
public interface AuthorityMapper {

    @Insert("INSERT INTO authorities(username, authority) " +
            "VALUES (#{username}, 'ROLE_USER')")
    void createUserAuthority(User user);
}
