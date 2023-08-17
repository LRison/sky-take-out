package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rison
 * @Date 2023/8/17 8:32
 */
@RestController
@Api("分类相关接口")
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param categoryDTO
     * @return
     */
    @ApiOperation("新增分类")
    @PostMapping
    public Result save(@RequestBody CategoryDTO categoryDTO) {

        log.info("新增分类{}", categoryDTO);
        categoryService.save(categoryDTO);

        return Result.success();
    }

    /**
     * 分页分类查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分类分页查询:{}", categoryPageQueryDTO);

        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);

        return Result.success(pageResult);

    }

    /**
     * 启用禁用管理
     *
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用状态管理")
    public Result status(@PathVariable("status") Integer status, Long id) {
        log.info("启用禁用状态管理:{},{}", id, status);

        categoryService.status(status, id);
        return Result.success();
    }

    /**
     * 根据id删除分类菜品
     *
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteById(Long id) {

        log.info("删除菜品的id:{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据id修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result updateById(@RequestBody CategoryDTO categoryDTO){
         log.info("修改分类{}",categoryDTO);

         categoryService.update(categoryDTO);

        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){

       List<Category> list =categoryService.list(type);
       return Result.success(list);

    }




}
