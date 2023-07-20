package com.make.assure.daos;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.make.assure.models.Seller;

@Repository
public interface SellerDao extends CrudRepository<Seller, Integer>{
	

	@Query(value="select * from seller s where s.user_id= :userId", nativeQuery=true)
    Seller fetchSellerByUserId(int userId);
	
	@Query(value="select s.seller_id from seller s where s.contact_number= :contactNumber", nativeQuery=true)
    int fetchSellerIdByPhoneNo(String contactNumber);
	
	
}
