# 🌐 Distributed Web Crawler

## 🚀 Overview
This is a **high-performance distributed web crawler** built using **Java, Spring Boot, Kafka, Redis, and Elasticsearch**. It efficiently fetches, parses, deduplicates, and indexes web pages for fast searching.

## 🔥 Features
✅ **Microservices Architecture** – Independently scalable services
✅ **Asynchronous Processing** – Uses Kafka & Redis for efficiency
✅ **Elasticsearch Integration** – Enables full-text search on crawled pages
✅ **Scalability & Fault Tolerance** – Designed to handle large-scale crawling
✅ **Deduplication System** – Prevents duplicate URL processing

## 🏗️ Architecture
```
   [Internet] → [Crawler] → [Parser] → [URL Extractor] → [Deduplicator] → [Queue] → [Crawlers]
                                         ↓
                                      [Elasticsearch (Search Index)]
```
### **🔹 Service Responsibilities**
- **Crawler Service** – Fetches web pages from the internet.
- **HTML Parser Service** – Extracts text & metadata from raw HTML.
- **URL Extractor Service** – Extracts and sends unique links for crawling.
- **Deduplicator Service** – Removes duplicate URLs using Redis/Bloom Filters.
- **URL Queue Service** – Manages the queue of URLs to be crawled.
- **Search Indexer (Elasticsearch)** – Enables fast keyword-based searching.

## ⚙️ Tech Stack
- **Backend:** Java, Spring Boot
- **Message Queue:** Kafka / RabbitMQ
- **Database:** Redis (Deduplication), PostgreSQL (Metadata)
- **Search Engine:** Elasticsearch
- **Containerization:** Docker, Kubernetes (for deployment)

## 🛠️ Setup & Installation
### **1️⃣ Prerequisites**
- Java 17+
- Docker & Docker Compose
- Kafka & Zookeeper
- Elasticsearch & Redis

### **2️⃣ Clone the Repository**
```bash
git clone https://github.com/yourusername/web-crawler.git
cd web-crawler
```

### **3️⃣ Run Services with Docker Compose**
```bash
docker-compose up -d
```

### **4️⃣ Start Each Microservice**
Run each service separately using:
```bash
cd crawler-service && mvn spring-boot:run
cd parser-service && mvn spring-boot:run
cd extractor-service && mvn spring-boot:run
...
```

## 🚀 Usage
### **1️⃣ Add a Seed URL to Start Crawling**
```bash
curl -X POST http://localhost:{urlservice's port} -d '['url']' -H "Content-Type: application/json"
```

### **2️⃣ Search Indexed Pages**
```bash
curl -X GET 'http://localhost:9200/webpages/_search?q=your_keyword'
```

## 📊 Performance Optimizations
- **Asynchronous processing with RabbitMQ** for handling high throughput
- **Redis caching** for fast deduplication
- **Parallel crawling with multiple workers**
- **Batch indexing in Elasticsearch** for optimized search performance

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

💡 **Contributions are welcome!** Feel free to submit PRs or issues. Happy Crawling! 🚀

