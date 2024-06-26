package kg.booster.spec_example.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    Long id;
    String name;
    Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;


}
