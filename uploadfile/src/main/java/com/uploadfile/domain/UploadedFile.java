package com.uploadfile.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Uploaded File Metadata Entity
 * Entity for store and get data from database
 */

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "file")
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "uploaded_time")
    private Date uploadedDate;

    @Column(name = "size")
    private Long size;
}
