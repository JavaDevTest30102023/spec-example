package kg.booster.spec_example.controllers.v3;

import kg.booster.spec_example.controllers.ProductController;
import kg.booster.spec_example.controllers.v2.ProductControllerV2;
import kg.booster.spec_example.models.Product;
import kg.booster.spec_example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3/product")
public class ProductControllerV3 extends ProductControllerV2 {
    private final ProductService productService;
    public ProductControllerV3(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

    @GetMapping("/filt")
    public ResponseEntity<?> findProducts(@RequestParam(required = false) Long id,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false, name = "min_price") Double minPrice,
                                          @RequestParam(required = false, name = "max_price") Double maxPrice,
                                          @RequestParam(required = false, name = "category_name") String categoryName,
                                          @RequestParam(required = false, name = "category_active") Boolean categoryActive,
                                          @RequestParam(required = false, name = "shop_id") Long shopId) {
        List<Product> productList =  productService.findProducts(id, name, minPrice, maxPrice,categoryName, categoryActive, shopId);

        return ResponseEntity.ok(productList);
    }
}
