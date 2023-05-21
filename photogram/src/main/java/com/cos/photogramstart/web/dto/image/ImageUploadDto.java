package com.cos.photogramstart.web.dto.image;


import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.image.image;
import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {
	private MultipartFile file;
	private String caption;
	
	public image toEntity(String postImageUrl, PrincipalDetails principalDetails) {
		return image.builder()
				.caption(caption)
				.postImageUrl(postImageUrl)
				.user(principalDetails)
				.build();
	}
}
