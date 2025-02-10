package com.azimsh3r.parserservice.service;

import com.azimsh3r.parserservice.model.WebPage;
import com.azimsh3r.parserservice.repository.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexingService {
    private final WebPageRepository webPageRepository;

    @Autowired
    public IndexingService(WebPageRepository webPageRepository) {
        this.webPageRepository = webPageRepository;
    }

    public WebPage save(WebPage webPage) {
        return webPageRepository.save(webPage);
    }
}
