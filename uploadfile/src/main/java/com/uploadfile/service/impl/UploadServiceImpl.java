package com.uploadfile.service.impl;

import com.uploadfile.configuration.UploadFileProperties;
import com.uploadfile.domain.UploadedFile;
import com.uploadfile.repository.UploadFileRepository;
import com.uploadfile.service.UploadException;
import com.uploadfile.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * Implement service for upload, find metadata
 */
@Service
@Transactional
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadFileProperties properties;

    @Autowired
    private UploadFileRepository repository;

    @Override
    public UploadedFile saveFile(MultipartFile file) {
        // Get the file and save it somewhere\
        storeFile(file);
        return saveFileMetadata(file);
    }

    @Override
    public List<UploadedFile> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UploadedFile> findByFileName(String fileName, long size) {
        if (fileName == null && size == 0) return repository.findAll();

        if (fileName == null) return repository.findBySize(size);

        return repository.findByFileNameAndSize(fileName, size);
    }

    private void storeFile(MultipartFile file) {
        try {
            Path path = Paths.get(properties.getPath(), file.getOriginalFilename());
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            throw new UploadException(e);
        }

    }

    private UploadedFile saveFileMetadata(MultipartFile file) {
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFileName(file.getOriginalFilename());
        uploadedFile.setFilePath(properties.getPath());
        uploadedFile.setSize(file.getSize());
        uploadedFile.setUploadedDate(new Date());

        return repository.save(uploadedFile);
    }
}
