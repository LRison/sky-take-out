package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author Rison
 * @Date 2023/8/19 14:31
 */
public interface DishService {
    /**
     * 新增菜品和相对应的口味
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
