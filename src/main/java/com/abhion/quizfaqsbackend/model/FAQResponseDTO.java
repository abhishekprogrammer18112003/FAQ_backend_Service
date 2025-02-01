package com.abhion.quizfaqsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FAQResponseDTO {
    private String question;
    private String answer;
}
