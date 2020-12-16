package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.LoginInfoDto;
import com.example.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import com.example.domain.LoginInfo;
import com.example.mapper.LoginInfoMapper;
import com.example.service.LoginInfoService;

/**
 * @Author: jianghao
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Autowired
    private LoginInfoMapper loginInfoMapper;

    /**
     * 添加
     *
     * @param loginInfo
     * @return
     */
    @Override
    public int insertLoginInfo(LoginInfo loginInfo) {
        return this.loginInfoMapper.insert(loginInfo);
    }

    /**
     * 分页查询
     *
     * @param loginInfoDto
     * @return
     */
    @Override
    public DataGridView listForPage(LoginInfoDto loginInfoDto) {
        Page<LoginInfo> page = new Page<>(loginInfoDto.getPageNum(), loginInfoDto.getPageSize());
        QueryWrapper<LoginInfo> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(loginInfoDto.getUserName()), LoginInfo.COL_USER_NAME, loginInfoDto.getUserName());
        qw.like(StringUtils.isNotBlank(loginInfoDto.getIpAddr()), LoginInfo.COL_IP_ADDR, loginInfoDto.getIpAddr());
        qw.like(StringUtils.isNotBlank(loginInfoDto.getLoginAccount()), LoginInfo.COL_LOGIN_ACCOUNT, loginInfoDto.getLoginAccount());
        qw.eq(StringUtils.isNotBlank(loginInfoDto.getLoginStatus()), LoginInfo.COL_LOGIN_STATUS, loginInfoDto.getLoginStatus());
        qw.eq(StringUtils.isNotBlank(loginInfoDto.getLoginType()), LoginInfo.COL_LOGIN_TYPE, loginInfoDto.getLoginType());
        qw.ge(null != loginInfoDto.getBeginTime(), LoginInfo.COL_LOGIN_TIME, loginInfoDto.getBeginTime());
        qw.le(null != loginInfoDto.getEndTime(), LoginInfo.COL_LOGIN_TIME, loginInfoDto.getEndTime());
        qw.orderByDesc(LoginInfo.COL_LOGIN_TIME);
        this.loginInfoMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 删除登陆日志
     *
     * @param infoIds
     * @return
     */
    @Override
    public int deleteLoginInfoByIds(Long[] infoIds) {
        List<Long> ids = Arrays.asList(infoIds);
        if (ids.size() > 0) {
            return this.loginInfoMapper.deleteBatchIds(ids);
        }
        return 0;
    }

    /**
     * 清空登陆日志
     *
     * @return
     */
    @Override
    public int clearLoginInfo() {
        return this.loginInfoMapper.delete(null);
    }

}
