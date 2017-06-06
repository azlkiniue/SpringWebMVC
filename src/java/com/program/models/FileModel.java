package com.program.models;

import org.springframework.web.multipart.MultipartFile;

public class FileModel {

    private MultipartFile file;
    private int id;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
