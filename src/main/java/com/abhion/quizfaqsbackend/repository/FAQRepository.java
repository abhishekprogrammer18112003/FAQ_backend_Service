package com.abhion.quizfaqsbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhion.quizfaqsbackend.model.FAQ;

import java.util.List;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
    List<FAQ> findByLanguage(String language);
}