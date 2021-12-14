package com.devsuperior.bds04.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class); //usar um objeto de logger ele vai imprimir mensagens no console obdecendo padrao "quem é erro etc"
	
	@Autowired
	private UserRepository repository;
	
	@Override   //implementar uma busca por email simples
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	User user = repository.findByEmail(username); //esse username ta igual email
	if (user == null ) { //se o usuario for nullo ele lança exerção
		logger.error("User not Found: " + username);
		throw new UsernameNotFoundException("Email not found");
	}
	logger.info("User Found: " + username);
	return user;
	
	}

}
