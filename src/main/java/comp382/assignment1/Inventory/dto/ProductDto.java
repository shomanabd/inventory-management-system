package comp382.assignment1.Inventory.dto;



/**
 * Entity class representing a Product.
 */

public class ProductDto {


    private Long id;

    private String name;

    private String description;

    private Double price;

    // Getters and setters

    /**
     * Get the ID of the product.
     *
     * @return The ID of the product.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the product.
     *
     * @param description The description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}