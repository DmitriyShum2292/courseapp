package com.example.courseapp.controller;


//import com.example.courseapp.service.MetaDataService;
//import com.example.courseapp.model.MetaData;
import com.example.courseapp.service.SQSService;
import com.example.courseapp.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FileController {


    @Autowired
    private StorageServiceImpl storageService;

    @Autowired
    private SQSService sqsService;
//    @Autowired
//    private MetaDataService metaDataService;

//    @GetMapping
//    public ResponseEntity<List<MetaData>> getAllData() {
//        return new ResponseEntity<>(metaDataService.findAll(), HttpStatus.OK);
//    }

//    @GetMapping("/{name}")
//    public ResponseEntity<List<MetaData>> getDataByFileName(@RequestParam String name) {
//        return new ResponseEntity<>(metaDataService.findByName(name), HttpStatus.OK);
//    }

    @PostMapping("/file")
    public ResponseEntity uploadFile(@RequestParam(value = "file") MultipartFile file) {
//        MetaData metaData = new MetaData();
//        metaData.setName(file.getOriginalFilename());
//        metaData.setLastUpdate(new Date());
//        metaData.setSize(file.getSize());
        storageService.uploadFile(file);
        sqsService.sendMessageToQueue(file.getOriginalFilename() + ", " + file.getSize() + ", " + file.getContentType());
//        metaDataService.save(metaData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/file/{name}")
    public ResponseEntity<ByteArrayResource> downloadFileByName (@PathVariable String name) {

            byte[] data = storageService.downloadFile(name);
            ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + name + "\"")
                .body(resource);
    }

    @DeleteMapping("/file/{name}")
    public ResponseEntity deleteFileByName (@PathVariable String name) {
        storageService.deleteFile(name);
//        metaDataService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<MetaData> findById(@RequestParam long id) {
//        return new ResponseEntity<>(metaDataService.findById(id), HttpStatus.OK);
//    }

//    @PostMapping
//    public ResponseEntity postObj(@RequestBody MetaData metaData) {
//        metaDataService.save(metaData);
//        return new ResponseEntity<>(metaData, HttpStatus.CREATED);
//    }

//    @DeleteMapping
//    public ResponseEntity deleteObj (@RequestParam long id) {
//        metaDataService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
