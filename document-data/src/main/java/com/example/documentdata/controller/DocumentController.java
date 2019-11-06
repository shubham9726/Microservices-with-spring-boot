package com.example.documentdata.controller;

import com.example.documentdata.model.Document;
import com.example.documentdata.model.DocumentPath;
import com.example.documentdata.service.DocumentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class DocumentController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @Autowired
    private DocumentService documentService;

    /**
     *
     * @return : local server port
     */
    @RequestMapping("/getProperty")
    public String home() {
        return "Hello from Item Service running at port: " + environment.getProperty("local.server.port");
    }

    /**
     *
     * @param name : name
     * @return : document
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/{name}")
    public Document getGallery(@PathVariable final String name) {
        Document document = new Document();
        document.setName(name);
        List<Object> data = restTemplate.getForObject("http://studentdata-service/getAllData/", List.class);
        document.setDocument(data);
        return document;
    }

    /**
     *
     * @return : local server port
     */
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Document service running at port: " + environment.getProperty("local.server.port");
    }

    /**
     *
     * @return : name
     */
    @RequestMapping("NameData")
    public String getName(){
        String name = restTemplate.getForObject("http://studentdata-service/name/",String.class);
        return name;
    }

    /**
     *
     * @param multipartFile : multipartFile
     * @param name : name
     * @return : Id of document
     * @throws IOException
     */
    @RequestMapping("/multiFileUpload/{name}")
    public DocumentPath mulipleFileUpload(@RequestParam MultipartFile multipartFile, @PathVariable final String name) throws IOException {

        return documentService.multiFileUpload(name,multipartFile);
    }

    /**
     *
     * @return : List of Document Id's
     */
    @RequestMapping("/getAllDocument")
    public List<DocumentPath> getAllDocument() {
        return documentService.getAllDocument();
    }
}
