package com.xy.studyboot.controller;

import io.swagger.annotations.Api;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * WJY
 *
 */
@RestController
@RequestMapping(value = "/uploads")
@Api(tags = "1.0v" , description = "文件上传" , value = "文件上传")
public class FileUploadsController {

    @PostMapping("upload1")
    public void upload1(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("文件类型："+file.getContentType());
        System.out.println("文件名：" + file.getOriginalFilename());
        System.out.println("文件大小：" + file.getSize());
        // 将文件写入到本地
        file.transferTo(new File("F:\\logs" + file.getOriginalFilename()));
        System.out.println("上传文件结束");
        Map<String, String> result = new HashMap<>(16);
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
    }

    @PostMapping("upload2")
    public void upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (null != files && files.length > 0){
            for (MultipartFile file:files) {
                System.out.println("文件类型："+file.getContentType());
                System.out.println("文件名：" + file.getOriginalFilename());
                System.out.println("文件大小：" + file.getSize());
                // 将文件写入到本地
                file.transferTo(new File("F:\\logs" + file.getOriginalFilename()));
                System.out.println("上传文件结束");
            }
        }
    }

    @PostMapping("upload3")
    public void upload3(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File("F:\\app\\chapter16\\test.jpg");
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }

}
