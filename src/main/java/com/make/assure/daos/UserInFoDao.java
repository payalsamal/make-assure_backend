package com.make.assure.daos;

import org.springframework.data.repository.CrudRepository;

import com.make.assure.models.UserInfo;

public interface UserInFoDao extends CrudRepository<UserInfo, Integer>{

	
}
