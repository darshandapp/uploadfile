package com.uploadfile.repository;

import com.uploadfile.domain.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository, use it to connect to database and get data
 * It base on UploadedFile object
 */
@Repository
public interface UploadFileRepository extends JpaRepository<UploadedFile, Long> {
    /**
     * Custom query for find by findName Or by size
     * @param fileName any string
     * @param size size
     * @return list of uploadedFile
     */
    @Query(("Select f from UploadedFile f where f.fileName like CONCAT('%',:fileName,'%') or f.size=:size"))
    List<UploadedFile> findByFileNameAndSize(@Param("fileName") String fileName, @Param("size") long size);

    List<UploadedFile> findBySize(long size);
}
