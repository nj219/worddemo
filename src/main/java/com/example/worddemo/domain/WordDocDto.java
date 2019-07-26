package com.example.worddemo.domain;

import javax.persistence.*;

/**
 * @ClassName WordDocDto1
 * @Author shangpinyuan06
 * @Date 2019/7/25 13:16
 **/
@Entity
@Table(name = "test")
public class WordDocDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "file_name")
    private String fileName;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
