package com.trainings.restsecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trainings.restsecurity.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	List<Product> products = new ArrayList<>();
	long id = 123;

	ProductServiceImpl() {
		Product product = new Product();
		product.setId(++id);
		product.setDescription("Restful course");
		products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public long addProduct(Product product) {
		product.setId(++id);
		products.add(product);
		return product.getId();
	}

}
