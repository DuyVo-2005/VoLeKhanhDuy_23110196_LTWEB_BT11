package vn.khanhduy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(columnDefinition = "nvarchar(255)")
	String name;
	
	@Column(columnDefinition = "nvarchar(255)")
	String brand;
	
	@Column(columnDefinition = "nvarchar(255)")
	String madein;
	
	float price;
}
