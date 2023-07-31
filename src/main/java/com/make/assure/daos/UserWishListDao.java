package com.make.assure.daos;

import org.springframework.data.repository.CrudRepository;

import com.make.assure.models.UserWishList;

public interface UserWishListDao extends CrudRepository<UserWishList, Integer>{

}
