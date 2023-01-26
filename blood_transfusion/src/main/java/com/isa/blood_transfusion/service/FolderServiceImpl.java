package com.isa.blood_transfusion.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FolderServiceImpl implements FolderService {
    @Override
    public void createFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                System.out.println("Folder created at " + path);
            } else {
                System.out.println("Failed to create folder at " + path);
            }
        } else {
            System.out.println("Folder already exists at " + path);
        }
    }
}
