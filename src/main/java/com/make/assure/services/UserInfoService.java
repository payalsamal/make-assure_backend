package com.make.assure.services;

import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.make.assure.daos.ProductDao;
import com.make.assure.daos.UserInFoDao;
import com.make.assure.daos.UserWishListDao;
import com.make.assure.exceptions.BusinessException;
import com.make.assure.models.Product;
import com.make.assure.models.ResponseData;
import com.make.assure.models.UserInfo;
import com.make.assure.models.UserWishList;

@Service
public class UserInfoService {

	@Autowired
	UserInFoDao userDao;

	@Autowired
	UserWishListDao userWishList;

	@Autowired
	ProductDao productDao;

	/**
	 * FUNCODE-USERSER001
	 * 
	 * @param user
	 * @return
	 */
	public ResponseData<UserInfo> saveUser(UserInfo user) {
		try {
			UserInfo userInfo = userDao.save(user);
			return new ResponseData<>(HttpStatus.OK, "User saved sucessfully", userInfo);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to save user", "USERSER001", "unable to save user", e);
		}
	}

	/**
	 * FUNCODE-USERSER002
	 * 
	 * @param user
	 * @return
	 */

	public ResponseData<Optional<UserInfo>> fetchUserById(int id) {
		try {
			Optional<UserInfo> user = userDao.findById(id);
			return new ResponseData<>(HttpStatus.OK, "User fetched sucessfully", user);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to fetch user", "USERSER002", "unable to fetch user", e);
		}
	}

	public ResponseData<Optional<UserInfo>> editUser(UserInfo user) {
		try {
			// userDao.
			// return new ResponseData<>(HttpStatus.OK,"User fetched sucessfully",user);
			return null;
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to fetch user", "USERSER002", "unable to fetch user", e);
		}
	}

	public ResponseData<UserInfo> fetchUserByPhoneNumber(String mobileNumber) {
		try {
			UserInfo user = userDao.fetchSellerByUserMobileNumber(mobileNumber);
			return new ResponseData<>(HttpStatus.OK, "User fetched sucessfully", user);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to fetch user", "USERSER002", "unable to fetch user", e);
		}
	}

	public ResponseData<List<Product>> getUserLikedProduct(int userId) {

		try {
			List<Integer> productIds = userWishList.fetchUserWishListById(userId);

			List<Product> products = productDao.fetchProductByProductIds(productIds);
			return new ResponseData<>(HttpStatus.OK, "Product fetched sucessfully", products);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to fetch product", "USERSER002", "unable to fetch user", e);
		}

	}
	@Transactional
	public ResponseData<String> removeProductFromLiked(int userId, int productId) {

		try {

			userWishList.deleteProductFromWishList(userId, productId);
			return new ResponseData<>(HttpStatus.OK, "Removed from wishlist",null);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to product", "USERSER002", "unable to remove product", e);
		}

	}

}
