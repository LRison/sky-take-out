package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rison
 * @Date 2023/8/19 15:10
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}


