package com.azimsh3r.crawlerservice.util;

import com.azimsh3r.crawlerservice.dto.WebPageDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebDataFetcher {

    public WebPageDTO fetchHtml(String url) throws IOException {
        int timeout = 5000;

        Document document = Jsoup.connect(url)
                .timeout(timeout)
                .get();

        if (document == null) {
            throw new IOException("Failed to fetch HTML content: No content retrieved.");
        }

        WebPageDTO webPage = new WebPageDTO();
        webPage.setUrl(url);
        webPage.setTitle(document.title());
        webPage.setContent(document.html());

        return webPage;
    }

}
