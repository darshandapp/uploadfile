package com.uploadfile.service;

import com.uploadfile.domain.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Service handle all business
 * link between API and repository
 */
public interface UploadService {

    UploadedFile saveFile(MultipartFile file);

    List<UploadedFile> findAll();

    List<UploadedFile> findByFileName(String fileName, long size);
}
