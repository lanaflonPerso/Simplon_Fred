package co.simplon.study.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import co.simplon.study.domain.Greeting;

@Service
public class GreetingService {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	public Greeting getGreetingMessage(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
