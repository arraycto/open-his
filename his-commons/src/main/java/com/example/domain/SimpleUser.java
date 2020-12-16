package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: jianghao
 * 登陆用户的数据传输对象
 * 远程调用需要实体类实现序列化接口
 * 调用远程service的方法需要用到当前是谁登陆的
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser implements Serializable {

    private Serializable userId;
    private String userName;

}