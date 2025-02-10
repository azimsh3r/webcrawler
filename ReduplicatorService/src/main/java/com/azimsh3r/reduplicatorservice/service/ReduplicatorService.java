package com.azimsh3r.reduplicatorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReduplicatorService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public ReduplicatorService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public List<String> findUnprocessedUrls(List<String> urls) {
        return urls.stream()
                .filter(u -> !Boolean.TRUE.equals(redisTemplate.opsForSet().isMember("processedUrls", u)))
                .collect(Collectors.toList());
    }

    public void addToSet(String url) {
        redisTemplate.opsForSet().add("processedUrls", url);
    }
}
