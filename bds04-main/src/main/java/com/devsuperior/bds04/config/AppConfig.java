package com.devsuperior.bds04.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration //classe de configuração
public class AppConfig {
	
	@Value("${jwt.secret}")
	private String jwtSecret;

	@Bean //anotação de metedo (Esta dizendo que essa instancia vai ser um componente gerenciado pelo springboot e vai poder injetar em outras classes e componentes
	public BCryptPasswordEncoder passwordEncoder() {
		 
		return new BCryptPasswordEncoder(); //foi instanciado
		
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtSecret);
		return tokenConverter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	 
}
