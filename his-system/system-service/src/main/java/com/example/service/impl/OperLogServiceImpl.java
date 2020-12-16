package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.OperLogDto;
import com.example.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import com.example.domain.OperLog;
import com.example.mapper.OperLogMapper;
import com.example.service.OperLogService;

/**
 * @Author: jianghao
 */
@Service
public class OperLogServiceImpl  implements OperLogService{

    @Autowired
    private OperLogMapper operLogMapper;

    /**
     * 插入操作日志
     *
     * @param operLog
     */
    @Override
    public void insertOperLog(OperLog operLog) {
        operLogMapper.insert(operLog);
    }

    /**
     * 分页查询操作日志
     *
     * @param operLogDto
     * @return
     */
    @Override
    public DataGridView listForPage(OperLogDto operLogDto) {
        Page<OperLog> page = new Page<>(operLogDto.getPageNum(), operLogDto.getPageSize());
        QueryWrapper<OperLog> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(operLogDto.getOperName()), OperLog.COL_OPER_NAME, operLogDto.getOperName());
        qw.like(StringUtils.isNotBlank(operLogDto.getTitle()), OperLog.COL_TITLE, operLogDto.getTitle());
        qw.eq(StringUtils.isNotBlank(operLogDto.getBusinessType()), OperLog.COL_BUSINESS_TYPE, operLogDto.getBusinessType());
        qw.eq(StringUtils.isNotBlank(operLogDto.getStatus()), OperLog.COL_STATUS, operLogDto.getStatus());
        qw.ge(null != operLogDto.getBeginTime(), OperLog.COL_OPER_TIME, operLogDto.getBeginTime());
        qw.le(null != operLogDto.getEndTime(), OperLog.COL_OPER_TIME, operLogDto.getEndTime());
        qw.orderByDesc(OperLog.COL_OPER_TIME);
        this.operLogMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 根据ID删除操作日志
     *
     * @param infoIds
     * @return
     */
    @Override
    public int deleteOperLogByIds(Long[] infoIds) {
        if (null != infoIds && infoIds.length > 0) {
            return this.operLogMapper.deleteBatchIds(Arrays.asList(infoIds));
        }
        return 0;
    }

    /**
     * 清空操作日志
     *
     * @return
     */
    @Override
    public int clearAllOperLog() {
        return this.operLogMapper.delete(null);
    }

}
