package com.cos.photogramstart.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//공통응답 Dto
public class CMRespDto<T> {

	private int code; 
	private String messgae;
	private T data;
//	private Map<String, String> errorMap;
}
