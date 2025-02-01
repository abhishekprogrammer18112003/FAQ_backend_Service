// package com.abhion.quizfaqsbackend.service;



// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.stereotype.Service;

// import com.abhion.quizfaqsbackend.model.FAQResponseDTO;

// import java.time.Duration;
// import java.util.List;

// @Service
// public class FAQCacheService {

//     private final RedisTemplate<String, Object> redisTemplate;

//     public FAQCacheService(RedisTemplate<String, Object> redisTemplate) {
//         this.redisTemplate = redisTemplate;
//     }

//     private static final String CACHE_KEY_PREFIX = "faqs:";

//     // Store FAQs in Redis Cache
//     public void cacheFAQs(String lang, List<FAQResponseDTO> faqs) {
//         redisTemplate.opsForValue().set(CACHE_KEY_PREFIX + lang, faqs, Duration.ofHours(1));
//     }

//     // Retrieve FAQs from Redis Cache
//     public List<com.abhion.quizfaqsbackend.model.FAQResponseDTO> getCachedFAQs(String lang) {
//         return (List<FAQResponseDTO>) redisTemplate.opsForValue().get(CACHE_KEY_PREFIX + lang);
//     }

//     // Remove FAQs from Redis Cache
//     public void clearCache(String lang) {
//         redisTemplate.delete(CACHE_KEY_PREFIX + lang);
//     }
// }