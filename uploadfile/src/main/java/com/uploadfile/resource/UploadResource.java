package com.uploadfile.resource;

import com.uploadfile.service.impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Config All End-Point(API), each end point have a method with @RequestMapping
 * tag @RequestMapping above class is root path
 * any API will be: http:/localhost:8080/file/....
 */
@RestController
@RequestMapping(value = "/file")
public class UploadResource {
    @Autowired
    private UploadServiceImpl service;


    /**
     * Api for upload new file
     * @param file file to upload
     * @return record in database if uploaded successful
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity upload(MultipartFile file){
        try {
            return ResponseEntity.ok(service.saveFile(file));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Api for get all file in database
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * API get uploaded file by a criterion
     * @param fileName any string
     * @param size size of file
     * @return list file have name or size
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam(value = "fileName", required = false) String fileName,
                               @RequestParam(value = "size", defaultValue = "0") int size ){
        return ResponseEntity.ok(service.findByFileName(fileName, size));
    }
}
