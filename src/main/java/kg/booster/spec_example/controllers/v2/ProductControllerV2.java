package kg.booster.spec_example.controllers.v2;

import kg.booster.spec_example.models.Product;
import kg.booster.spec_example.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductControllerV2 extends kg.booster.spec_example.controllers.ProductController {

    private final ProductService productService;

    public ProductControllerV2(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

    @GetMapping("/v2/filter")
    public ResponseEntity<?> findProducts(@RequestParam(required = false) Long id,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false, name = "min_price") Double minPrice,
                                          @RequestParam(required = false, name = "max_price") Double maxPrice,
                                          @RequestParam(required = false, name = "category_name") String categoryName,
                                          @RequestParam(required = false, name = "category_active") Boolean categoryActive) {
        List<Product> products = productService.findProducts(id, name, minPrice, maxPrice, categoryName, categoryActive);

        if (products.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(products);
    }
}
