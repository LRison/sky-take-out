package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author Rison
 * @Date 2023/8/19 10:59
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags="通用接口")
@Slf4j
public class CommonController {

    @Autowired
    AliOssUtil aliOssUtil;
    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传;{}",file);

        try {
            //原始文件名
            final String originalFilename = file.getOriginalFilename();
            //文件后缀
            final String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接文件名
            final String objectName = UUID.randomUUID().toString() + extension;
            //上传至阿里云oos并返回文件路径
            final String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败,{}",e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
