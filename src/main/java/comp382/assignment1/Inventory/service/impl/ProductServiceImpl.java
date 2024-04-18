package comp382.assignment1.Inventory.service.impl;

import comp382.assignment1.Inventory.dto.ProductDto;
import comp382.assignment1.Inventory.entity.Product;
import comp382.assignment1.Inventory.exception.ResourceNotFoundException;
import comp382.assignment1.Inventory.repository.ProductRepository;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing product-related operations.
 * This class implements the EntityService interface for generic CRUD operations on Product entities.
 */
@Service
public class ProductServiceImpl implements EntityService<Product, ProductDto> {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Creates a new product.
     *
     * @param productDto The DTO containing data for the new product
     * @return The DTO representing the created product
     */
    @Override
    public ProductDto createEntity(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);
        return mapToDto(newProduct);
    }

    /**
     * Retrieves all products.
     *
     * @return A list of DTOs representing all products
     */
    @Override
    public List<ProductDto> getAllEntities() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve
     * @return The DTO representing the retrieved product
     * @throws ResourceNotFoundException if the product with the given ID is not found
     */
    @Override
    public ProductDto getEntityById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapToDto(product);
    }

    /**
     * Updates an existing product.
     *
     * @param productDto The DTO containing updated data for the product
     * @param id         The ID of the product to update
     * @return The DTO representing the updated product
     * @throws ResourceNotFoundException if the product with the given ID is not found
     */
    @Override
    public ProductDto updateEntity(ProductDto productDto, long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(product);
        return mapToDto(updatedProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete
     * @throws ResourceNotFoundException if the product with the given ID is not found
     */
    @Override
    public void deleteEntityById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }

    /**
     * Maps a Product entity to a ProductDto.
     *
     * @param product The Product entity
     * @return The corresponding ProductDto
     */
    private ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    /**
     * Maps a ProductDto to a Product entity.
     *
     * @param productDto The ProductDto
     * @return The corresponding Product entity
     */
    private Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
