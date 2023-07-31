package com.make.assure.daos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.make.assure.models.Seller;
import com.make.assure.models.UserInfo;

@Repository
public interface UserInFoDao extends CrudRepository<UserInfo, Integer>{

//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE public.user_info\r\n"
//			+ "SET first_name=:firstName, last_name=:lastName, email_id=:emailId, mobile_number=:mobileNumber, gender=:gender, is_seller=:isSeller, is_active=:isActive, deleted=:deleted, dob=:dob,\r\n"
//			+ "WHERE user_id=nextval('user_info_user_id_seq'::regclass)")
//	void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);
//    Seller fetchSellerByUserId(int userId);
//	
}
