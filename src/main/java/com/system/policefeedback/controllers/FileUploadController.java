package com.system.policefeedback.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.system.policefeedback.helpers.FTPClientHelper;
import com.system.policefeedback.models.UploadResponse;
import com.system.policefeedback.services.ImageCompressionServiceImpl;

@RestController
public class FileUploadController {

    @Autowired
    private ImageCompressionServiceImpl imageCompressionService;

    @Autowired
    private FTPClientHelper ftpClientHelper;

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadQRCodeImage(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            // Compress image to 600x600 pixels at 50% quality
            InputStream compressedInputStream = imageCompressionService.compressImage(inputStream, 1200, 1200, 1.0f);

            String originalFileName = file.getOriginalFilename();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String remoteFileName = originalFileName + "_" + timestamp;

            String fileUrl = ftpClientHelper.uploadFile(compressedInputStream, remoteFileName);

            if (fileUrl != null) {
                return ResponseEntity.ok(new UploadResponse(200, fileUrl));
            } else {
                return ResponseEntity.status(500).body(new UploadResponse(500, "File upload failed for: " + originalFileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new UploadResponse(500, "Error: " + e.getMessage()));
        }
    }
}
