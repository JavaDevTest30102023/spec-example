package kg.booster.spec_example.services;

import kg.booster.spec_example.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findProducts(Long id, String name, Double minPrice, Double maxPrice);
    List<Product> findProducts(Long id, String name, Double minPrice, Double maxPrice, String categoryName, Boolean active);
}
