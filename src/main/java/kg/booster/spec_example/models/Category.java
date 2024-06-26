package kg.booster.spec_example.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "categories")
public class Category {
    @Id
            @GeneratedValue
    Long id;
    String name;
    boolean active;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    Shop shop;

}
