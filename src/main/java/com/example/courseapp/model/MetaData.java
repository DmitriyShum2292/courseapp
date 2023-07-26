//package com.example.courseapp.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.Date;
//
////@Entity
//public class MetaData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String name;
//    private Date lastUpdate;
//    private long size;
//
//    public MetaData() {
//    }
//
//    public MetaData(long id, String name, Date lastUpdate, long size) {
//        this.id = id;
//        this.name = name;
//        this.lastUpdate = lastUpdate;
//        this.size = size;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Date getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(Date lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    public long getSize() {
//        return size;
//    }
//
//    public void setSize(long size) {
//        this.size = size;
//    }
//
//    @Override
//    public String toString() {
//        return "MetaData{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", lastUpdate=" + lastUpdate +
//                ", size=" + size +
//                '}';
//    }
//}