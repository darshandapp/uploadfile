package com.uploadfile.service;

/**
 * Exception when upload file
 */
public class UploadException extends RuntimeException {
    private static final String MESSAGE = "Failed when save file to Disk";
    public UploadException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
