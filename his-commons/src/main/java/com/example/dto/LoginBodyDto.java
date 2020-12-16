package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: jianghao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBodyDto implements Serializable {

    //  用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    //  密码
    @NotBlank(message = "用户密码不能为空")
    private String password;
    // 验证码
    private String code;

}
