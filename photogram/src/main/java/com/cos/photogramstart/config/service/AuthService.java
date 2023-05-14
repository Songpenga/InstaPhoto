package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service //1.IOC 2. 트랜잭션 관리
public class AuthService {
	
	private final UserRepository userRepository;

	public User register(User user) {
		//회원가입 진행
		User userEntity = userRepository.save(user);
		return userEntity;
	}
}
