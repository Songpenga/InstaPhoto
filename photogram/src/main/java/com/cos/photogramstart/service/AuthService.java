package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service //1.IOC 2. 트랜잭션 관리
public class AuthService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional //트랜잭션관리 - Write(Insert, update, Delete)
	public User register(User user) throws RuntimeException{
		// 회원가입 진행
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER"); // 관리자 ROLE_ADMIN
		User userEntity = null;
		userEntity = userRepository.save(user);
		
		return userEntity;
	}
}
