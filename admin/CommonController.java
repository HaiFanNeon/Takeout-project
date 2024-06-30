package com.sky.controller.admin;


import com.sky.result.Result;
import com.sky.utils.TengOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/admin/common")
@Slf4j
@RestController
@Api(tags = "通用接口")
public class CommonController {

    @Autowired
    private TengOssUtil tengOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传{}", file);
        String filePath = tengOssUtil.upload(file);
        log.info("上传文件的路径是{}", filePath);
        return Result.success(filePath);
    }
}
