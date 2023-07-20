package com.make.assure.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMedia {
	@Id
	private long sellerId;
	private String mediaType;
	private String socialId;

}
