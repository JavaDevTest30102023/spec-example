package kg.booster.spec_example.services.impl;

import kg.booster.spec_example.models.Product;
import kg.booster.spec_example.repositories.ProductRepo;
import kg.booster.spec_example.services.ProductService;
import kg.booster.spec_example.specifications.ProductSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findProducts(Long id, String name, Double minPrice, Double maxPrice) {
        Specification<Product> specification = Specification
                .where(ProductSpecifications.byId(id))
                .and(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.betweenPrice(minPrice, maxPrice));

        List<Product> products = productRepo.findAll(specification);

        return products;
    }

    @Override
    public List<Product> findProducts(Long id, String name, Double minPrice, Double maxPrice, String categoryName, Boolean active) {
        Specification<Product> specification = Specification
                .where(ProductSpecifications.byId(id))
                .and(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.betweenPrice(minPrice, maxPrice))
                .and(ProductSpecifications.byCategoryName(categoryName))
                .and(ProductSpecifications.byCategoryActive(active));

        List<Product> products = productRepo.findAll(specification);

        return products;
    }

    @Override
    public List<Product> findProducts(Long id, String name, Double minPrice, Double maxPrice, String categoryName, Boolean categoryActive, Long shopId) {
        Specification<Product> specification = Specification
                .where(ProductSpecifications.byId(id))
                .and(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.betweenPrice(minPrice, maxPrice))
                .and(ProductSpecifications.byCategoryName(categoryName))
                .and(ProductSpecifications.byCategoryActive(categoryActive))
                .and(ProductSpecifications.byShopId(shopId));

        List<Product> products = productRepo.findAll(specification);
        return products;
    }
}
