package vn.khanhduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.khanhduy.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
