package com.example.documentdata.service;

import com.example.documentdata.model.Document;
import com.example.documentdata.model.DocumentPath;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
    DocumentPath multiFileUpload(String name, MultipartFile multipartFile) throws IOException;

    List<DocumentPath> getAllDocument();
}
