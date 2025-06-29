# 🔗 Tiny URL – Low-Level Design Implementation (Java)

This repository contains a clean and scalable **Low-Level Design (LLD)** of a Tiny URL shortening system like [bit.ly](https://bit.ly/). This project demonstrates object-oriented design principles (SOLID), hashing techniques, collision handling, and modular code organization in Java.

---

## 📌 Problem Statement

> Design a system that converts a **long URL** into a **short, unique, fixed-length URL code**, and allows expanding the short URL back to the original long URL.  
>
> ### Functional Requirements:
> - Shorten a long URL into a short unique code.
> - Retrieve the original URL using the short code.
> - Handle **collisions** if two URLs hash to the same short code.
> - Avoid generating multiple codes for the same input URL.
> - Must support special characters and large URLs.
>
> ### Non-Functional Requirements:
> - Stateless and horizontally scalable.
> - High availability and performance.
> - Extensible for persistence layer (e.g., Redis, DB).
> - Secure and consistent hash generation.

---

## 🧠 System Design (LLD)

| Component | Description |
|----------|-------------|
| `HashGenerator` | Generates a SHA-256 hash of the input URL and truncates it to 6 bytes (48 bits). |
| `Base62Encoder` | Converts the numeric hash to a Base62 encoded string for short codes. |
| `UrlRepository` | Interface for URL persistence (abstracted for future DB/Redis support). |
| `InMemoryUrlRepository` | Stores short ↔ original URL mappings in memory using HashMaps. |
| `UrlShortenerService` | Encapsulates the logic for shortening, expanding, and handling collisions. |
| `Main` | Demonstrates how to use the service by shortening and expanding sample URLs. |

### 🧩 Code Structure

```
Tiny_Url/
├── Base62Encoder.java         # Base62 encoding utility
├── HashGenerator.java         # Hashing + truncation logic
├── UrlRepository.java         # Interface for storage abstraction
├── InMemoryUrlRepository.java # In-memory storage implementation
├── UrlShortenerService.java   # Core logic for shortening and expanding
└── Main.java                  # Demo runner
```

## ⚙️ How It Works

1. URL is hashed using SHA-256 → then 6 bytes (48 bits) are taken.
2. Those 48 bits are converted to a **Base62 string** (short code).
3. If collision occurs, we retry with a **salted version** of the URL.
4. In-memory maps track the original-to-short and short-to-original mappings.

---

## 🛠️ How to Run

### Prerequisites:
- Java 17+ (or Java 11)
- Maven (optional)

### Compile & Run

```bash
javac *.java
java Main

