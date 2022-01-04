package com.springboot.restful.webservice.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.Product;
import com.springboot.restful.webservice.repository.ProductRepository;
import com.springboot.restful.webservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> getProductById(Long productId) {
		Optional<Product> product =  productRepository.findById(productId);
		
		if (!product.isPresent()) {   
			throw new RecordNotFoundException("ProductServiceImpl/getProductById : Product not found. productId -> " + productId);
		}
				
		return product;
	}

	@Override
	public List<Product> getProductList() {
		List<Product> productList = productRepository.findAll();
		
		if (productList == null || productList.size() == 0) {
			throw new RecordNotFoundException("ProductServiceImpl/getProductList: Product list is empty. ");
		}
		
		return productList;
	}

}
