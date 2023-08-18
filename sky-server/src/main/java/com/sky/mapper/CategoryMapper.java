package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rison
 * @Date 2023/8/17 8:38
 */
@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     * @param category
     */
    @AutoFill(OperationType.INSERT)
    @Insert("insert INTO " +
            "category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "values" +
            " (#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Category category);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     * @param category
     */
    @AutoFill(value= OperationType.UPDATE)
    void update(Category category);

    /**
     * 删除分类
     * @param id
     */
    @Delete("delete from category where id =#{id}")
    void deleteById(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
