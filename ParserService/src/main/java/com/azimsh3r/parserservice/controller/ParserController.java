package com.azimsh3r.parserservice.controller;

import com.azimsh3r.parserservice.client.UrlServiceClient;
import com.azimsh3r.parserservice.dto.WebPageDTO;
import com.azimsh3r.parserservice.model.WebPage;
import com.azimsh3r.parserservice.service.IndexingService;
import com.azimsh3r.parserservice.service.ParserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class ParserController {
    private final ParserService parserService;

    private final UrlServiceClient urlExtractorServiceClient;

    private final IndexingService indexingService;

    private final ModelMapper modelMapper;

    @Autowired
    public ParserController(ParserService parserService, UrlServiceClient urlServiceClient, IndexingService indexingService, ModelMapper modelMapper) {
        this.parserService = parserService;
        this.urlExtractorServiceClient = urlServiceClient;
        this.indexingService = indexingService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<String> saveWebPage(@RequestBody WebPageDTO webPageDTO) {
        List<String> extractedUrlList = parserService.extractUrls(webPageDTO.getContent());
        urlExtractorServiceClient.publishUrls(extractedUrlList);

        String textBody = parserService.extractText(webPageDTO.getContent());

        WebPage page = modelMapper.map(webPageDTO, WebPage.class);
        page.setText(textBody);
        page.setTimestamp(new Timestamp(System.currentTimeMillis()));

        indexingService.save(page);
        return ResponseEntity.ok("Successful");
    }
}
