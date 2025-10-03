package vn.khanhduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.khanhduy.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
