package org.bigj.blackjack.service;

import org.bigj.blackjack.domain.entity.User;
import org.bigj.blackjack.domain.mapper.AuthorityMapper;
import org.bigj.blackjack.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by arthan on 02.10.2016. | Project game-platform
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AuthorityMapper authorityMapper;

    public User byUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Transactional
    public void createUser(User user) {
        userMapper.createUser(user);
        authorityMapper.createUserAuthority(user);
    }
}
