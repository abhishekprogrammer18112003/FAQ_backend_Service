FAQ Management System (Spring Boot + Caffeine Cache + MySQL + Docker)

📌 Introduction

This project is a FAQ Management System built using Spring Boot, MySQL, and Caffeine Cache for fast in-memory caching.

✅ Removed Redis and replaced it with Caffeine Cache

✅ Removed tests from the project

✅ Implemented caching for improved performance

✅ Uses Docker for containerization

📌 Features

Manage FAQs with a REST API

Multi-language support (English, Hindi, Bengali)

Caffeine Cache to speed up API responses

Dockerized setup for easy deployment

📌 Installation Steps

1️⃣ Clone the Repository

2️⃣ Build the Application

Ensure you have Maven installed, then build the project:

command :- mvn clean package

3️⃣ Run the Application using Docker

command :- docker-compose up --build



📌 API Usage Examples

1️⃣ Fetch All FAQs (Default English)

curl -X GET "http://localhost:8080/api/faqs"

Response:

[
    {
        "question": "What is AI?",
        "answer": "AI stands for Artificial Intelligence."
    }
]

2️⃣ Fetch FAQs in Hindi

curl -X GET "http://localhost:8080/api/faqs?lang=hi"

Response:
[
    {
        "question": "API का पूर्ण रूप क्या है?",
        "answer": "API का पूरा नाम एप्लीकेशन इंटरफ़ेस है।"
    },
]

2️⃣ Fetch FAQs in Bengali

curl -X GET "http://localhost:8080/api/faqs?lang=bn"

Response:
[
    {
        "question": "এপিআই এর পুরো আকার কী?",
        "answer": "<p>API অ্যাপ্লিকেশান ইন্টারফেস এর সংক্ষিপ্ত রূপ।</p>"
    },
]

3️⃣ Add a New FAQ

curl -X POST "http://localhost:8080/api/faqs" \
     -H "Content-Type: application/json" \
     -d '{
    "question": "What is the fullform of API?",
    "answer": "<p>API stands for Application interface.</p>"
}'

Response:

{
    "id": 4,
    "question": "What is the fullform of API?",
    "answer": "<p>API stands for Application interface.</p>",
    "questionHi": "API का फुलफॉर्म क्या है?",
    "answerHi": "<p>API का मतलब एप्लीकेशन इंटरफेस (Application Interface) होता है। </p>",
    "questionBn": "API এর পুরো রুপ কি?",
    "answerBn": "<p>এপিআই দ্বারা Application interface বোঝায়।</p>",
    "language": "en"
}



📌 Summary of Changes

Removed Redis → Using Caffeine Cache instead.

Removed Tests → To simplify the project setup.

Implemented Docker Support → Easy deployment with MySQL.

Added Logging → Indicates whether data is fetched from the database or cache.

🚀 Now the FAQ Management System is optimized for performance and easy deployment! 🎯🔥
