package com.cos.photogramstart.domain.user;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 디비에 테이블을 생성
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	@Column(length = 20,  unique = true)
	private String username; 
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	private String website; // 웹 사이트
	private String bio; // 자기 소개
	@Column(nullable = false)
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; // 사진
	private String role; // 권한
	
	
	//연관 관계의 주인의 아니므로 테이블에 칼럼을 만들지 마라
	//User을 Select할 때 해당 User id로 등록된 image들을 다 가져와라
	//LAZY : User을 Select할 때 하당 User id로 등록된 image들을 가져오지 마라
	// 			-> 대신 getImages() 함수가 호출될 때 가져와라 
	//Eager : User을 Select할 때 하당 User id로 등록된 image들을 전부 Join해서 가져와라
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"user"}) // 참조
	private List<Image> images; // 양방향 매핑
	
	private LocalDateTime createDate;
	
	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
