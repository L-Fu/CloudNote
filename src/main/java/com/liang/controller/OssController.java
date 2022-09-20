package com.liang.controller;

import com.liang.util.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/oss")
@CrossOrigin
public class OssController {

    @Autowired
    OssUtils ossUtils;

    @PostMapping("/uploadOneFile")
    public String uploadFile(MultipartFile file) {
        //返回上传oss的url
        return ossUtils.uploadOneFile(file);
    }

    @PostMapping("/uploadArrayFile")
    public List<String> uploadArrayFile(MultipartFile[] files) {
        //返回上传oss的url
        return ossUtils.uploadArrayFile(files);
    }

    @PostMapping("/deleteFile")
    public boolean deleteFile(@RequestBody String fileUrl) {
        //返回是否删除成功
        return ossUtils.deleteFile(fileUrl);
    }

    @PostMapping("/uploadImag")
    public String uploadImag(MultipartFile file) {
        //返回上传oss的url
        return ossUtils.uploadImg(file);
    }

}

