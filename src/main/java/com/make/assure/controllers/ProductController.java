package com.make.assure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.make.assure.models.Product;
import com.make.assure.models.ResponseData;
import com.make.assure.services.ProductService;

@RestController
@RequestMapping("v1/product")
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/")
	public ResponseEntity<ResponseData<Product>>saveProduct(@RequestParam("product") String product ,@RequestParam MultipartFile image)
	{
		ResponseData<Product>response=	productService.saveProduct(product, image);
		return new ResponseEntity<>(response,response.getStatus());
	}
	
	@GetMapping("/{sellerId}")
	public ResponseEntity<ResponseData<List<Product>>>getProductsBySellerId(@PathVariable int sellerId)
	{
		return new ResponseEntity<>(productService.getProductsBySellerId(sellerId),HttpStatus.OK);
	}
	
}
