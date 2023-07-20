package com.make.assure.models;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SellerDto {


	
	private String emailId;
	private String businessName;
	private int deleted;
	private String businessDetails;
	private String category;
	private String country;
	private String state;
	private String postalCode;
	private String district;
	private String village;
	private List<SocialMedia> social;
	private String contactNumber;
	private int isActive;
	private String latitude;
	private long userId;
	private MultipartFile profileImage;
	private MultipartFile coverImage;
	private String longitude;
	

}
