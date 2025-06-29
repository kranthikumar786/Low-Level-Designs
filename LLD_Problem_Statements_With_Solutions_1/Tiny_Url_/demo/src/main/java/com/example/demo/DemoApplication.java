package com.example.demo;

import com.example.demo.service.UrlShortenerService;
import com.example.demo.util.Base62Encoder;
import com.example.demo.util.HashGenerator;
import com.example.demo.repository.InMemoryUrlRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		UrlShortenerService service = new UrlShortenerService(
				new HashGenerator(),
				new Base62Encoder(),
				new InMemoryUrlRepository()
		);

		String url1 = "https://example.com";
		String url2 = "https://bit.ly/@Kranthi_123!!";

		String short1 = service.shorten(url1);
		String short2 = service.shorten(url2);

		System.out.println("Shortened URLs:");
		System.out.println(url1 + " → " + short1);
		System.out.println(url2 + " → " + short2);

		System.out.println("\nExpanded URLs:");
		System.out.println(short1 + " → " + service.expand(short1));
		System.out.println(short2 + " → " + service.expand(short2));
	}
}
