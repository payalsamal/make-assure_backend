package com.make.assure.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.make.assure.models.Product;
import com.make.assure.models.Seller;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{
	
	@Query(value="select * from product p where p.seller_id= :sellerId", nativeQuery=true)
    List<Product> fetchProductBySellerId(long sellerId);

}
