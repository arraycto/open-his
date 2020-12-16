package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

/**
 * @Author: jianghao
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     * @return
     */
    @Override
    public User queryUserByPhone(String phone) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(User.COL_PHONE,phone);
        User user = this.userMapper.selectOne(qw);
        return user;
    }

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户编号
     * @return
     */
    @Override
    public User getOne(Long userId) {
        return this.userMapper.selectById(userId);
    }
}
