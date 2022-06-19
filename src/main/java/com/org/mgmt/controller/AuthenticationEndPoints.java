package com.org.mgmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.mgmt.config.JwtProvider;
import com.org.mgmt.dto.JwtResponseDTO;
import com.org.mgmt.dto.LoginDTO;

@RestController
@RequestMapping("/auth")
public class AuthenticationEndPoints {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtProvider tokenProvider;

	@PostMapping(path = "/signin", produces = "application/xml")
	public ResponseEntity<JwtResponseDTO> authenticateUser(@Valid @RequestBody LoginDTO login) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
		jwtResponseDTO.setJwtToken(jwt);
		return ResponseEntity.ok(jwtResponseDTO);
	}
}
