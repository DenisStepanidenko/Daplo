package com.example.servingwebcontent.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download2")
public class DownloadController2 {

    @GetMapping
    public void download (HttpServletRequest request, HttpServletResponse response) throws IOException {

        // The file to be downloaded.
        Path file = Paths.get("C:/Users/stepa/OneDrive/Рабочий стол/программирование/MyApp2/app-debug.apk");

        // Get the media type of the file
        String contentType = Files.probeContentType(file);
        if (contentType == null) {
            // Use the default media type
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        response.setContentType(contentType);
        // File Size
        response.setContentLengthLong(Files.size(file));
        /**
         * Building the Content-Disposition header with the ContentDisposition utility class can avoid the problem of garbled downloaded file names.
         */
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                .filename(file.getFileName().toString(), StandardCharsets.UTF_8)
                .build()
                .toString());
        // Response data to the client
        Files.copy(file, response.getOutputStream());
    }
}
