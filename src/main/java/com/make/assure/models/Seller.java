package com.make.assure.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sellerId;
	@Column
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
	private String contactNumber;
	private int isActive;
	private String latitude;
	private long userId;
	private byte[] profileImage;
	private byte[] coverImage;
	private String longitude;
	
}
