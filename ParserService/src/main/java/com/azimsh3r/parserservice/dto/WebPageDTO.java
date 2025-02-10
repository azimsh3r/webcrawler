package com.azimsh3r.parserservice.dto;

import lombok.Data;


@Data
public class WebPageDTO {
    private String url;
    private String title;
    private String content;
}
