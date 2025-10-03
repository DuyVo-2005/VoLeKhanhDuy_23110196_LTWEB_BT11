package vn.khanhduy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.khanhduy.entities.Product;
import vn.khanhduy.repository.ProductRepository;
import vn.khanhduy.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public void delete(Long id) {
		productRepository.existsById(id);
	}

	@Override
	public Product get(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> listAll() {
		return productRepository.findAll();
	}

}
