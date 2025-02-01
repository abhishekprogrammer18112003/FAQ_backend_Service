package com.abhion.quizfaqsbackend.model;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FAQRequestDTO {

    @NotBlank(message = "Question cannot be empty")
    private String question;

    @NotBlank(message = "Answer cannot be empty")
    private String answer;
}
