package com.springboot.restful.webservice.service;

import java.util.List;
import java.util.Optional;
import com.springboot.restful.webservice.model.Product;

public interface ProductService {

	public Optional<Product> getProductById(Long productId);
	public List<Product> getProductList();
}
