package comp382.assignment1.Inventory.controller;

import comp382.assignment1.Inventory.dto.ProductDto;
import comp382.assignment1.Inventory.entity.Product;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling product-related operations.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final EntityService<Product, ProductDto> productService;

    public ProductController(EntityService<Product, ProductDto> productService) {
        this.productService = productService;
    }

    /**
     * Endpoint to retrieve all products.
     *
     * @return ResponseEntity containing a list of ProductDto representing all products
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllEntities());
    }

    /**
     * Endpoint to retrieve a product by its ID.
     *
     * @param id The ID of the product to retrieve
     * @return ResponseEntity containing the ProductDto representing the retrieved product
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getEntityById(id));
    }

    /**
     * Endpoint to create a new product.
     *
     * @param productDto The ProductDto containing data for the new product
     * @return ResponseEntity containing the created ProductDto
     */
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createEntity(productDto));
    }

    /**
     * Endpoint to update an existing product.
     *
     * @param id         The ID of the product to update
     * @param productDto The ProductDto containing updated data for the product
     * @return ResponseEntity containing the updated ProductDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(productService.updateEntity(productDto, id));
    }

    /**
     * Endpoint to delete a product by its ID.
     *
     * @param id The ID of the product to delete
     * @return ResponseEntity with status OK if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}

