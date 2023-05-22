package com.cos.photogramstart.web.dto.image;


import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.domain.image.image;
import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {
	private MultipartFile file;
	private String caption;
	
	public image toEntity(String postImageUrl, User user) {
		return image.builder()
				.caption(caption)
				.postImageUrl(postImageUrl)
				.user(user)
				.build();
	}
}
