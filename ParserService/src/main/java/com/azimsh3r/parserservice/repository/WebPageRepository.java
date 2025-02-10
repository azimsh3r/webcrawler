package com.azimsh3r.parserservice.repository;

import com.azimsh3r.parserservice.model.WebPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebPageRepository extends ElasticsearchRepository<WebPage, String> {
    public WebPage findByUrl(String url);
}
