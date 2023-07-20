package com.make.assure.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.make.assure.models.ResponseData;
import com.make.assure.models.Seller;
import com.make.assure.models.SellerResponse;
import com.make.assure.services.SellerService;

@RestController
@RequestMapping("/v1/seller")
public class SellerController {

	@Autowired
	SellerService sellerService;

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<ResponseData<Seller>> saveSeller(@RequestParam("seller") String seller, @RequestParam("media") String media, @RequestParam MultipartFile profileImage, @RequestParam MultipartFile coverImage) throws IOException {
		
		
		
		ResponseData<Seller> response = sellerService.saveSeller(seller,media,profileImage,coverImage);
		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping("/")
	public ResponseEntity<ResponseData<SellerResponse>> fetchSellerByUserId(@RequestParam int userId
			) throws JsonMappingException, JsonProcessingException {
		
		
		ResponseData<SellerResponse> response = sellerService.fetchSellerByUserId(userId);
		return new ResponseEntity<>(response, response.getStatus());
	}
}
