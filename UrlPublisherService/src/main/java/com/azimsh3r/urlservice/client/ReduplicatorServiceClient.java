package com.azimsh3r.urlservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="ReduplicatorService")
public interface ReduplicatorServiceClient {

    @PostMapping
    ResponseEntity<List<String>> filterProcessedUrls(List<String> urlList);
}
