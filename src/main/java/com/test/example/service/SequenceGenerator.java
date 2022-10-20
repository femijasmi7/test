package com.test.example.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {

	public Long getNextID() {
		Random random = new Random();
		Long x = random.nextLong(123456789);
		return x;
	}

}
