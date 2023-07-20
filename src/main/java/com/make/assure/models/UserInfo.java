package com.make.assure.models;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "gender")
	private String gender;
	@Column(name = "is_active")
	private int isActive;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "deleted")
	private int deleted;
	@Column(name = "created_on_utc")
	private LocalDateTime createdOnUtc;
	private int isSeller;
}
