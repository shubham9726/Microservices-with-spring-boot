package com.example.documentdata.controller;

import com.example.documentdata.model.Document;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class DocumentController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;
    private static final String NAME = "hello world..!";

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
    @RequestMapping("name")
    public String getName(){
        return NAME;
    }
}
