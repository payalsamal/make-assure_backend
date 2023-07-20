package com.make.assure.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.make.assure.daos.BusinessPhotosDao;
import com.make.assure.daos.ProductDao;
import com.make.assure.daos.SellerDao;
import com.make.assure.daos.SocialMediaDao;
import com.make.assure.exceptions.BusinessException;
import com.make.assure.models.Product;
import com.make.assure.models.ResponseData;
import com.make.assure.models.Seller;
import com.make.assure.models.SellerResponse;
import com.make.assure.models.SocialMedia;

@Service
public class SellerService {

	@Autowired
	SellerDao sellerDao;
	@Autowired
	BusinessPhotosDao businessPhotosDao;
	@Autowired
	SocialMediaDao socialMediaDao;
	@Autowired
	
	ProductDao productDao;

	@Transactional
	public ResponseData<Seller> saveSeller(String seller,String media,MultipartFile profileImage,MultipartFile coverImage) {
		try {

//			Seller seller = new Seller();
//			BeanUtils.copyProperties(sellerDto, seller);
//			seller.setProfileImage(sellerDto.getProfileImage().getBytes());
//			seller.setCoverImage(sellerDto.getProfileImage().getBytes());
			
			ObjectMapper mapper = new ObjectMapper();
			Seller sellerDetails  = mapper.readValue(seller, Seller.class);
			sellerDetails.setProfileImage(profileImage.getBytes());
			sellerDetails.setCoverImage(coverImage.getBytes());
			
			List<SocialMedia>socials=mapper.readValue(media, mapper.getTypeFactory().constructCollectionType(List.class, SocialMedia.class));
			
			
			
			
			Seller sell= sellerDao.save(sellerDetails);
			//int sellerId = sellerDao.fetchSellerIdByPhoneNo(sellerDetails.getContactNumber());
			//List<SocialMedia> socials = sellerDto.getSocial();
			if(ObjectUtils.isNotEmpty(socials)) {
			for (SocialMedia socialMedia : socials) {
				socialMedia.setSellerId(sell.getSellerId());
			}
			socialMediaDao.saveAll(socials);
			}

			return new ResponseData<>(HttpStatus.OK, "BusinessPage created sucessfully", sell);
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to create business page", "SELLERSER001",
					"unable to create business page", e);
		}
	}

	public ResponseData<SellerResponse> fetchSellerByUserId(int userId) {
		try {
			Seller seller = sellerDao.fetchSellerByUserId(userId);
			List<Product>products=productDao.fetchProductBySellerId(seller.getSellerId());
			return new ResponseData<>(HttpStatus.OK, "Seller details fetched successfully", SellerResponse.builder().seller(seller).products(products).build());
		} catch (Exception e) {
			throw new BusinessException("A101", "unable to fetch business page", "SELLERSER002",
					"unable to fetch business page", e);
		}
	}
}
