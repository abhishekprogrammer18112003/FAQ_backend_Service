package com.abhion.quizfaqsbackend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abhion.quizfaqsbackend.model.FAQ;
import com.abhion.quizfaqsbackend.model.FAQRequestDTO;
import com.abhion.quizfaqsbackend.model.FAQResponseDTO;
import com.abhion.quizfaqsbackend.service.FAQService;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
public class FAQController {

    private final FAQService faqService;

    @GetMapping
    public ResponseEntity<List<FAQResponseDTO>> getFAQs(@RequestParam(value = "lang", defaultValue = "en") String lang) {
        return ResponseEntity.ok(faqService.getAllFAQs(lang));
    }

    @PostMapping
    public ResponseEntity<FAQ> addFAQ(@RequestBody FAQRequestDTO faqRequestDTO) {
        return ResponseEntity.ok(faqService.createFAQ(faqRequestDTO));
    }
}

