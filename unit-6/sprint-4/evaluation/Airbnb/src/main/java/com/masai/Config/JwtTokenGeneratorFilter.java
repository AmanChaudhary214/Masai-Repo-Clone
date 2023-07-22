package com.masai.Config;

import java.io.IOException;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());
			
//			String jwt = Jwts.builder().setIssuer("Aman").setSubject("JWT Token").claim("username", authentication.getName())
//							.claim("authorities", key)
		}
		
	}

	
}
