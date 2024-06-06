package kg.booster.spec_example.specifications;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import kg.booster.spec_example.models.Category;
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

    public static Specification<Product> byCategoryName(String categoryName){
        return (root, query, criteriaBuilder) -> {
            if (categoryName == null || categoryName.isBlank())
                return criteriaBuilder.conjunction();

            Join<Product, Category> categoryJoin = root.join("category", JoinType.INNER);

            return criteriaBuilder.like(categoryJoin.get("name"),"%" + categoryName + "%");
        };
    }

    public static Specification<Product> byCategoryActive(Boolean active){
        return (root, query, criteriaBuilder) -> {
            if (active == null)
                return criteriaBuilder.conjunction();

            Join<Product, Category> categoryJoin = root.join("category", JoinType.INNER);
            return criteriaBuilder.equal(categoryJoin.get("active"), active);

        };
    }





}
