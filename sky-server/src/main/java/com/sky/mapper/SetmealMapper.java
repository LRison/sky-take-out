package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Rison
 * @Date 2023/8/17 17:37
 */
@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id查询套餐数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{id}")
    Integer countByCategoryId(Long id);
}
