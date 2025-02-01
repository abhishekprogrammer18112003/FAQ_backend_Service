package com.abhion.quizfaqsbackend.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeminiTranslationService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiUrl;
    
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public GeminiTranslationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String translateText(String text, String targetLang) {
        // Construct the prompt
        String prompt = buildPrompt(text, targetLang);

        // Create the request body in the expected format
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[] {
                                Map.of("text", prompt)
                        })
                });

        // Call Gemini API
        String response = webClient.post()
                .uri(geminiUrl + geminiApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Extract and return the translated text
        return extractResponse(response);
    }

    private String extractResponse(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
        } catch (Exception e) {
            return "Error Processing Translation: " + e.getMessage();
        }
    }

    private String buildPrompt(String text, String targetLang) {
        return "Translate the following text to " + targetLang + ": " + text;
    }
}