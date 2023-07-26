//package com.example.courseapp.service.impl;
//
//import com.example.courseapp.model.MetaData;
//import com.example.courseapp.repository.MetaDataRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MetaDataService implements com.example.courseapp.service.MetaDataService {
//
//    @Autowired
//    private MetaDataRepo metadataRepository;
//
//    public MetaData save (MetaData metaData) {
//        return metadataRepository.save(metaData);
//    }
//
//    @Override
//    public List<MetaData> findAll() {
//        return metadataRepository.findAll();
//    }
//
//    @Override
//    public List<MetaData> findByName(String name) {
//        return metadataRepository.findByName(name);
//    }
//
//    @Override
//    public void deleteByName(String name) {
//        metadataRepository.deleteByName(name);
//    }
//
//    @Override
//    public MetaData findById(long id) {
//        return metadataRepository.findById(id).get();
//    }
//
//    @Override
//    public void deleteById(long id) {
//        metadataRepository.deleteById(id);
//    }
//}
