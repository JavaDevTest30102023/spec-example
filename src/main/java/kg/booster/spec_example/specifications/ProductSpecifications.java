package kg.booster.spec_example.specifications;

import kg.booster.spec_example.models.Product;
import org.springframework.data.jpa.domain.Specification;

import java.sql.DriverPropertyInfo;

public class ProductSpecifications {

    // where true and name = ? and price between ? and ?
    public static Specification<Product> byId(Long id){
        return (root, query, criteriaBuilder) -> {
            if (id == null)
                return criteriaBuilder.conjunction();

            return criteriaBuilder.equal(root.get("id"), id);
        };
    }

    public static Specification<Product> hasName(String name){
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank() || name.isEmpty())
                return criteriaBuilder.conjunction();
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Product> betweenPrice(Double minPrice, Double maxPrice){
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null)
                return criteriaBuilder.conjunction();
            else if (minPrice != null && maxPrice != null)
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            else if (minPrice != null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            else
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }








}
