package com.shop.file.controller;

import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import com.shop.file.service.FileService;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import javax.annotation.Nullable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@Slf4j
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/")
    @ResponseEncode
    public Object post(@RequestHeader Integer id,
                       @RequestBody MultipartFile multipartFile) throws Exception {
        String filename = fileService.post(id, multipartFile);
        log.info("用户{}放入了文件{}", id, filename);
        return filename;
    }

    @GetMapping("/{filename}")
    public void get(@RequestHeader @Nullable Integer id,
                    @PathVariable String filename,
                    HttpServletResponse response) throws Exception {
        log.info("用户{}下载了文件{}", id, filename);
        fileService.get(filename, response.getOutputStream());
    }

    @DeleteMapping("/{filename}")
    @ResponseEncode
    public Object delete(@RequestHeader String id,
                         @PathVariable String filename) throws Exception {
        log.info("用户{}删除了文件{}", id, filename);
        fileService.delete(id, filename);
        return "成功";
    }

    @GetMapping("/")
    @ResponseEncode
    public Object getAll(@RequestHeader String id) throws Exception {
        log.info("用户{}查看了自己的文件", id);
        return fileService.getImageNameBySeller(id);
    }
}
