package com.org.mgmt.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.org.mgmt.mapper.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	@Value("${jwt.secret}")
	private String secret;
	public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * 10;

	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_TOKEN_VALIDITY);

		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getUserUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
		} catch (MalformedJwtException ex) {
		} catch (ExpiredJwtException ex) {
		} catch (UnsupportedJwtException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return false;
	}
}
