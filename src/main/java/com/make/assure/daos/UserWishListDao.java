package com.make.assure.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.make.assure.models.UserWishList;

public interface UserWishListDao extends CrudRepository<UserWishList, Integer>{

	@Query(value="SELECT product_id FROM user_wishlist where user_id= :userId", nativeQuery=true)
    List<Integer> fetchUserWishListById(int userId);
	@Modifying
	@Query(value="DELETE FROM user_wishlist WHERE  user_id= :userId AND product_id= :productId", nativeQuery=true)
    int deleteProductFromWishList(@Param("userId") int userId, @Param("productId") int productId);
	
	
}
