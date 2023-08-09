package com.make.assure.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.make.assure.models.UserInfo;

@Repository
public interface UserInFoDao extends CrudRepository<UserInfo, Integer>{



	@Query(value="SELECT * FROM user_info where mobile_number= :mobileNumber", nativeQuery=true)
    UserInfo fetchSellerByUserMobileNumber(String mobileNumber);
	
	
}
