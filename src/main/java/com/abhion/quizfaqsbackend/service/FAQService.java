package com.abhion.quizfaqsbackend.service;

import com.abhion.quizfaqsbackend.model.FAQ;
import com.abhion.quizfaqsbackend.model.FAQRequestDTO;
import com.abhion.quizfaqsbackend.model.FAQResponseDTO;
import com.abhion.quizfaqsbackend.repository.FAQRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FAQService {

    private final FAQRepository faqRepository;
    private final GeminiTranslationService translationService;

    @Cacheable(value = "faqs", key = "#lang")
    public List<FAQResponseDTO> getAllFAQs(String lang) {
        System.out.println("⚠️ Cache MISS! Fetching FAQs from database for lang: " + lang);

        List<FAQ> faqs = faqRepository.findAll();
        List<FAQResponseDTO> responseList = faqs.stream()
                .map(faq -> new FAQResponseDTO(
                        getTranslatedText(faq.getQuestion(), faq.getQuestionHi(), faq.getQuestionBn(), lang),
                        getTranslatedText(faq.getAnswer(), faq.getAnswerHi(), faq.getAnswerBn(), lang)
                ))
                .toList();

        System.out.println("✅ FAQs stored in cache for lang: " + lang);
        return responseList;
    }

    @CacheEvict(value = "faqs", allEntries = true)
    public FAQ createFAQ(FAQRequestDTO faqRequestDTO) {
        System.out.println("🔹 New FAQ added, clearing cache...");

        FAQ faq = new FAQ();
        faq.setQuestion(faqRequestDTO.getQuestion());
        faq.setAnswer(faqRequestDTO.getAnswer());
        faq.setLanguage("en");

        faq.setQuestionHi(translationService.translateText(faqRequestDTO.getQuestion(), "Hindi"));
        faq.setAnswerHi(translationService.translateText(faqRequestDTO.getAnswer(), "Hindi"));
        faq.setQuestionBn(translationService.translateText(faqRequestDTO.getQuestion(), "Bengali"));
        faq.setAnswerBn(translationService.translateText(faqRequestDTO.getAnswer(), "Bengali"));

        return faqRepository.save(faq);
    }

    private String getTranslatedText(String original, String hi, String bn, String lang) {
        return switch (lang) {
            case "hi" -> (hi != null) ? hi : original;
            case "bn" -> (bn != null) ? bn : original;
            default -> original;
        };
    }
}
