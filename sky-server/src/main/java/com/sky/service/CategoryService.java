package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @author Rison
 * @Date 2023/8/17 8:35
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分页分类查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 启用禁用管理
     * @param status
     * @param id
     */
    /**
     * 启用禁用分类
     * @param status
     * @param id
     */
    void status(Integer status, Long id);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteById(Long id);
}
