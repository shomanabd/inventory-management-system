package comp382.assignment1.Inventory.service;

import java.util.List;

/**
 * Generic interface for CRUD operations on entities.
 * Author: Abdalkarim Abusalama
 * @param <T> The type of entity
 * @param <D> The type of DTO (Data Transfer Object) for the entity
 */
public interface EntityService<T, D> {
    /**
     * Create a new entity.
     * @param dto The DTO containing data for the new entity
     * @return The DTO representing the created entity
     */
    D createEntity(D dto);

    /**
     * Retrieve all entities.
     * @return A list of DTOs representing all entities
     */
    List<D> getAllEntities();

    /**
     * Retrieve an entity by its ID.
     * @param id The ID of the entity to retrieve
     * @return The DTO representing the retrieved entity
     */
    D getEntityById(long id);

    /**
     * Update an existing entity.
     * @param dto The DTO containing updated data for the entity
     * @param id The ID of the entity to update
     * @return The DTO representing the updated entity
     */
    D updateEntity(D dto, long id);

    /**
     * Delete an entity by its ID.
     * @param id The ID of the entity to delete
     */
    void deleteEntityById(long id);
}