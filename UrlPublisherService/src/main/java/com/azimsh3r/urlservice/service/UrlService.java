package com.azimsh3r.urlservice.service;

import com.azimsh3r.urlservice.client.ReduplicatorServiceClient;
import com.azimsh3r.urlservice.messaging.UrlEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    private final UrlEventProducer urlEventProducer;

    private final ReduplicatorServiceClient reduplicatorServiceClient;

    @Autowired
    public UrlService(UrlEventProducer urlEventProducer, ReduplicatorServiceClient reduplicatorServiceClient) {
        this.urlEventProducer = urlEventProducer;
        this.reduplicatorServiceClient = reduplicatorServiceClient;
    }

    public void publishUrls(List<String> urls) {
        List<String> unprocessedUrls = reduplicatorServiceClient.filterProcessedUrls(urls).getBody();

        if(unprocessedUrls != null) {
            unprocessedUrls.forEach(urlEventProducer::send);
        }
    }
}
