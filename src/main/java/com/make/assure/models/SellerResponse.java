package com.make.assure.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data@Builder

public class SellerResponse {

	Seller seller;
	List<Product>products;
}
