package com.abhion.quizfaqsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "faqs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FAQ {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Lob
    @Column(nullable = false)
    private String answer;  

    @Column(name = "question_hi")
    private String questionHi;

    @Column(name = "answer_hi")
    private String answerHi;

    @Column(name = "question_bn")
    private String questionBn;

    @Column(name = "answer_bn")
    private String answerBn;

    // ✅ Ensure default value for language
    @Column(nullable = false)
    private String language = "en";
}