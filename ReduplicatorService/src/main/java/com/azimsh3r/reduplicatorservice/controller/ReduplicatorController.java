package com.azimsh3r.reduplicatorservice.controller;

import com.azimsh3r.reduplicatorservice.service.ReduplicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReduplicatorController {
    private final ReduplicatorService reduplicatorService;

    @Autowired
    public ReduplicatorController(ReduplicatorService reduplicatorService) {
        this.reduplicatorService = reduplicatorService;
    }

    @PostMapping
    public ResponseEntity<List<String>> filterProcessedUrls(@RequestBody List<String> urlList) {
        List<String> unprocessedUrls = reduplicatorService.findUnprocessedUrls(urlList);

        unprocessedUrls.forEach(reduplicatorService::addToSet);

        return ResponseEntity.ok(unprocessedUrls);
    }
}
