package com.make.assure.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@Data
public class UserWishList {

	@Id
	private int userId;
	private int productId;
}
