package com.example.courseapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface StorageService {
    void uploadFile (MultipartFile file);
    byte[] downloadFile (String name);
    void deleteFile (String name);
    File convertMultipartFileToFile (MultipartFile file);
}
