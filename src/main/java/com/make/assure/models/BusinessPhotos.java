package com.make.assure.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusinessPhotos {
	@Id
	private int sellerId ;
	private byte[] photo;
	private LocalDateTime createdOn;
	
}
