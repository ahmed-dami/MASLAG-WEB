package com.masswl.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masswl.pi.model.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}