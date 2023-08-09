package com.make.assure.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.make.assure.daos.ProductDao;
import com.make.assure.exceptions.BusinessException;
import com.make.assure.models.Product;
import com.make.assure.models.ResponseData;

@Service
public class ProductService {

	
	@Autowired
	ProductDao productDao;
	
	@Transactional
	public ResponseData<Product>saveProduct(String productDetails,MultipartFile imageVideo)
	{
		try {
			ObjectMapper mapper=new ObjectMapper();
			Product product=mapper.readValue(productDetails, Product.class);
			
			product.setImageVideo(imageVideo.getBytes());
			Product productSaved=productDao.save(product);
			return new ResponseData<>(HttpStatus.OK, "product saved sucessfully", productSaved);
			
		}
		catch (Exception e) {

			throw new BusinessException("A101", "unable to save product",
					"PRODSER001", "unable to save product", e);
		
		}
	}
	@Transactional
	public ResponseData<List<Product>>getProductsBySellerId(int sellerId)
	{

		try {
			
			return new ResponseData<>(HttpStatus.OK, "product fetched sucessfully", productDao.getProductsBySellerId( sellerId));
			
		}
		catch (Exception e) {

			throw new BusinessException("A101", "unable fetch products",
					"PRODSER001", "unable fetch products", e);
		
		}
	
	}
}
