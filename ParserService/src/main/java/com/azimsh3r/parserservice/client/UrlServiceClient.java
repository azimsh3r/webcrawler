package com.azimsh3r.parserservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="UrlService")
public interface UrlServiceClient {

    @PostMapping
    ResponseEntity<String> publishUrls(List<String> urlList);
}
