package com.blog.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

	private LocalDateTime localDateTime;
	private String messeage;
	private String description;
	
}
