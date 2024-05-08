package com.example.pharmacy;


public class ProductMapper {
	public static ProductDto mapToProductDto(Product p) {
		return new ProductDto(p.getId(),p.getPname(),p.getQuantity(),p.getPrice());
	}
	
	public static Product mapToProduct(ProductDto pro) {
		return new Product(pro.getId(),pro.getPname(),pro.getQuantity(),pro.getPrice());
	}
}
