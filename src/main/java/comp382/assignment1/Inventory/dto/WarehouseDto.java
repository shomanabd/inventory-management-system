package comp382.assignment1.Inventory.dto;


/**
 * Entity class representing a Warehouse.
 */

public class WarehouseDto {


    private Long id;

    private String name;

    private String location;

    // Getters and setters

    /**
     * Get the ID of the warehouse.
     *
     * @return The ID of the warehouse.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the warehouse.
     *
     * @param id The ID of the warehouse.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the warehouse.
     *
     * @return The name of the warehouse.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the warehouse.
     *
     * @param name The name of the warehouse.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the location of the warehouse.
     *
     * @return The location of the warehouse.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of the warehouse.
     *
     * @param location The location of the warehouse.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}