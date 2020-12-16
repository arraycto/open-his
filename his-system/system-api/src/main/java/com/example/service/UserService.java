package com.example.service;

import com.example.domain.User;

/**
 * @Author: jianghao
 */
public interface UserService {

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     * @return
     */
    User queryUserByPhone(String phone);

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户编号
     * @return
     */
    User getOne(Long userId);

}
