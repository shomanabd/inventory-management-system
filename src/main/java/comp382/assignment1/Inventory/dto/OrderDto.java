package comp382.assignment1.Inventory.dto;



public class OrderDto {


    private Long id;

    private Long productId;

    private Integer quantity;

    private String status;

    // Getters and setters

    /**
     * Get the ID of the order.
     *
     * @return The ID of the order.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the order.
     *
     * @param id The ID of the order.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the product ID associated with the order.
     *
     * @return The product ID associated with the order.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Set the product ID associated with the order.
     *
     * @param productId The product ID associated with the order.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Get the quantity of the product in the order.
     *
     * @return The quantity of the product in the order.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product in the order.
     *
     * @param quantity The quantity of the product in the order.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order.
     *
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}