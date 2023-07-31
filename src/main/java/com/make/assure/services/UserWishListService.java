package com.make.assure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.assure.daos.UserWishListDao;
import com.make.assure.models.ResponseData;

@Service
public class UserWishListService {
	
	@Autowired
	UserWishListDao userWishListDao;
	
	public void addProductToWishList()
	{
		
	}
	
	

}
