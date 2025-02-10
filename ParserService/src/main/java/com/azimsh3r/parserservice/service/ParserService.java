package com.azimsh3r.parserservice.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {
    private static final Logger logger = LoggerFactory.getLogger(ParserService.class);

    public List<String> extractUrls(String body) {
        Document document = Jsoup.parse(body);
        Elements links = document.select("a[href]");

        List<String> extractedUrls = new ArrayList<>();
        links.forEach(link -> extractedUrls.add(link.attr("abs:href")));
        extractedUrls.stream().filter(link -> link.contains("https://"));

        logger.info("Parsed URLs: " + extractedUrls);

        return extractedUrls;
    }

    public String extractText(String html) {
        Document doc = Jsoup.parse(html);
        return doc.text();
    }

}
