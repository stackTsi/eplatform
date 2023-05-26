package com.project.eplatform.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class FileStorageService {
    private final String uploadDir;

    public FileStorageService(@Value("${file.upload-dir}") String uploadDir) {
        this.uploadDir = uploadDir;
        createUploadDirectory();
    }

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExtension = getFileExtension(fileName);

        // file extension check (custom method)
        if (!isFileTypeAllowed(fileExtension)) {
            throw new IllegalArgumentException("Invalid file type. Only PNG and JPG files are allowed.");
        }

        String filePath = Paths.get(uploadDir, fileName).toString();

        // save the file to the specified directory
        file.transferTo(new File(filePath));

        // return the relative path (context path) of the saved file
        return "/" + fileName;
    }
    public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found: " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    private boolean isFileTypeAllowed(String fileExtension) {
        List<String> allowedExtensions = Arrays.asList("png", "jpg", "jpeg");

        // check if the file extension is in the allowed list
        return allowedExtensions.contains(fileExtension.toLowerCase());
    }

    private void createUploadDirectory() {
        Path directoryPath = Paths.get(uploadDir);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create upload directory", e);
            }
        }
    }
}
