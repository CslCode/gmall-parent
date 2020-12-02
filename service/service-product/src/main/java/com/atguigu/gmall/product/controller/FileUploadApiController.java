package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import lombok.SneakyThrows;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chen
 * @creat 2020-12-01-13:54
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class FileUploadApiController {

    @SneakyThrows
    @RequestMapping("fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String url = "http://192.168.25.255:8080/";

        String path = this.getClass().getClassLoader().getResource("tracker.conf").getPath();
        ClientGlobal.init(path);
        //连接tracker
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        //连接storage
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //上传文件
        String filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        String[] jpgs = storageClient.upload_file(multipartFile.getBytes(), filenameExtension, null);

        //返回url
        for (String jpg : jpgs) {
            url = url + "/" + jpg;
        }
        return Result.ok(url);
    }
}
