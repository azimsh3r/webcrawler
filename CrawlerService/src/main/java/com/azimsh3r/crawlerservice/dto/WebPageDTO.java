package com.azimsh3r.crawlerservice.dto;

import lombok.Data;

@Data
public class WebPageDTO {
    private String url;

    private String title;

    private String content;
}
