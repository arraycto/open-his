package com.example.service;

import com.example.domain.Dept;
import com.example.dto.DeptDto;
import com.example.vo.DataGridView;

import java.util.List;

/**
 * @Author: jianghao
 */

public interface DeptService {

    /**
     * 分页查询
     *
     * @param deptDto
     * @return
     */
    DataGridView listPage(DeptDto deptDto);

    /**
     * 查询所有有效部门
     *
     * @return
     */
    List<Dept> list();

    /**
     * 根据ID查询一个
     *
     * @param deptId
     * @return
     */
    Dept getOne(Long deptId);

    /**
     * 添加一个部门
     *
     * @param deptDto
     * @return
     */
    int addDept(DeptDto deptDto);

    /**
     * 修改部门
     *
     * @param deptDto
     * @return
     */
    int updateDept(DeptDto deptDto);

    /**
     * 根据IDS删除部门
     *
     * @param deptIds
     * @return
     */
    int deleteDeptByIds(Long[] deptIds);

}

