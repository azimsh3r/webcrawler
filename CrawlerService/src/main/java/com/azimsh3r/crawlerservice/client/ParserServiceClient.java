package com.azimsh3r.crawlerservice.client;

import com.azimsh3r.crawlerservice.dto.WebPageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="ParserService")
public interface ParserServiceClient {
    @PostMapping
    ResponseEntity<String> saveWebPage(WebPageDTO webPageDTO);
}
