// package com.abhion.quizfaqsbackend;

// import com.abhion.quizfaqsbackend.model.FAQ;
// import com.abhion.quizfaqsbackend.model.FAQResponseDTO;
// import com.abhion.quizfaqsbackend.repository.FAQRepository;
// import com.abhion.quizfaqsbackend.service.FAQService;
// import com.abhion.quizfaqsbackend.service.GeminiTranslationService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import java.util.List;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class)
// public class FAQServiceTest {

//     @Mock
//     private FAQRepository faqRepository;

//     @Mock
//     private GeminiTranslationService translationService;

//     @InjectMocks
//     private FAQService faqService;

//     private List<FAQ> mockFAQs;

//     @BeforeEach
//     void setUp() {
//         // ✅ Mock FAQ data
//         mockFAQs = List.of(
//                 new FAQ(1L, "What is AI?", "<p>AI stands for Artificial Intelligence.</p>",
//                         "एआई क्या है?", "<p>एआई का अर्थ कृत्रिम बुद्धिमत्ता है।</p>",
//                         "এআই কি?", "<p>এআই মানে কৃত্রিম বুদ্ধিমত্তা।</p>", "en")
//         );

//         // ✅ Mock repository behavior
//         when(faqRepository.findAll()).thenReturn(mockFAQs);
//     }

//     @Test
//     public void testGetAllFAQs() {
//         List<FAQResponseDTO> faqs = faqService.getAllFAQs("hi");

//         // ✅ Expecting 1 FAQ to be returned
//         assertEquals(1, faqs.size());
//         assertEquals("एआई क्या है?", faqs.get(0).getQuestion());
//         assertEquals("<p>एआई का अर्थ कृत्रिम बुद्धिमत्ता है।</p>", faqs.get(0).getAnswer());

//         // ✅ Verify that `findAll()` was called once
//         verify(faqRepository, times(1)).findAll();
//     }
// }