package com.azimsh3r.crawlerservice.messaging;

import com.azimsh3r.crawlerservice.client.ParserServiceClient;
import com.azimsh3r.crawlerservice.dto.WebPageDTO;
import com.azimsh3r.crawlerservice.util.WebDataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQConsumer {
    public static final String QUEUE_NAME = "url.queue";

    private final WebDataFetcher webDataFetcher;
    private final ParserServiceClient parserServiceClient;
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Autowired
    public RabbitMQConsumer(WebDataFetcher webDataFetcher, ParserServiceClient parserServiceClient) {
        this.webDataFetcher = webDataFetcher;
        this.parserServiceClient = parserServiceClient;
    }

    @RabbitListener(queues = RabbitMQConsumer.QUEUE_NAME)
    public void receiveUrl(String message) {
        logger.info("Received message: " + message);

        WebPageDTO webPageDTO = null;
        try {
            webPageDTO = webDataFetcher.fetchHtml(message);

            parserServiceClient.saveWebPage(webPageDTO);
        } catch (IOException e) {
            logger.info("Error parsing " + message);
        }
    }
}
