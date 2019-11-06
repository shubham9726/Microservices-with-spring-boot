package com.example.documentdata.service.impl;

import com.example.documentdata.model.Document;
import com.example.documentdata.model.DocumentPath;
import com.example.documentdata.repository.DocumentRepository;
import com.example.documentdata.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Document Service
 */

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentPath multiFileUpload(String name, MultipartFile multipartFile) throws IOException {
        String MESSAGE = "MultiPartFile Not Found";
        if (multipartFile.isEmpty()){
            System.out.println(MESSAGE);
        }

        Document document = new Document();
        document.setName(name);
        List<Object> data = restTemplate.getForObject("http://studentdata-service/getAllData/", List.class);
        document.setDocument(data);
        String PATH = "/home/dz-gg-02/MicroServices/";
        String directoryName = PATH.concat(document.getName());
        String fileName = document.getName() + ".txt";

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }

        File file = new File(directoryName + "/" + fileName);
        File file1 = new File(directoryName + "/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file1);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(document.getDocument()));
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
        DocumentPath documentPath = new DocumentPath();
        documentPath.setPath(directoryName);
        return documentRepository.save(documentPath);
    }

    @Override
    public List<DocumentPath> getAllDocument() {
        return (List<DocumentPath>) documentRepository.findAll();
    }
}
