package com.example.demo.models;

import java.sql.Timestamp;

public class Image {

	private Long id;
	private String name;
	private String ext;
	private Timestamp createdtime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }
    public Timestamp getCreatedtime() {
        return createdtime;
    }
    public void setCreatedtime(Timestamp createdtime) {
        this.createdtime = createdtime;
    }
}
