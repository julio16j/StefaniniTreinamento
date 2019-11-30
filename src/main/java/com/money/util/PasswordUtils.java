package com.money.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	//$2a$10$pJmbjkZ5dqMgq/9VWJqZ7u3Hzvnej8A3iy60/8U9IM/YEorlURkIu
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}

}
