package com.make.assure.services;

import java.util.Optional;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.make.assure.daos.UserInFoDao;
import com.make.assure.exceptions.BusinessException;
import com.make.assure.models.ResponseData;
import com.make.assure.models.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	UserInFoDao userDao;
	

	/**
	 * FUNCODE-USERSER001
	 * 
	 * @param user
	 * @return
	 */
	public ResponseData<UserInfo> saveUser(UserInfo user) {
		try {
			UserInfo userInfo= userDao.save(user);
			return new ResponseData<UserInfo>(HttpStatus.OK, "User saved sucessfully", userInfo);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to save user",
					"USERSER001", "unable to save user", e);
		}
	}
	/**
	 * FUNCODE-USERSER002
	 * 
	 * @param user
	 * @return
	 */
	
	public ResponseData<Optional<UserInfo>>fetchUserById(int id)
	{
		try {
		Optional<UserInfo> user= userDao.findById(id);
		return new ResponseData<>(HttpStatus.OK,"User fetched sucessfully",user);
	}
	catch (Exception e) {
		throw new BusinessException("A101", "unable to fetch user",
				"USERSER002", "unable to fetch user", e);
	}
	}
	
	public ResponseData<Optional<UserInfo>>editUser(UserInfo user)
	{
		try {
		//userDao.
		//return new ResponseData<>(HttpStatus.OK,"User fetched sucessfully",user);
			return null;
	}
	catch (Exception e) {
		throw new BusinessException("A101", "unable to fetch user",
				"USERSER002", "unable to fetch user", e);
	}
	}
	public ResponseData<UserInfo>fetchUserByPhoneNumber(String mobileNumber )
	{
		try {
			UserInfo user=userDao.fetchSellerByUserMobileNumber(mobileNumber);
			return new ResponseData<>(HttpStatus.OK,"User fetched sucessfully",user);
	}
	catch (Exception e) {
		throw new BusinessException("A101", "unable to fetch user",
				"USERSER002", "unable to fetch user", e);
	}
	}
	
	
	
}
