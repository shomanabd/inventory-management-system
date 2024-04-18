package comp382.assignment1.Inventory.service.impl;

import comp382.assignment1.Inventory.dto.WarehouseDto;
import comp382.assignment1.Inventory.entity.Warehouse;
import comp382.assignment1.Inventory.exception.ResourceNotFoundException;
import comp382.assignment1.Inventory.repository.WarehouseRepository;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing warehouse-related operations.
 * This class implements the EntityService interface for generic CRUD operations on Warehouse entities.
 */
@Service
public class WarehouseServiceImpl implements EntityService<Warehouse, WarehouseDto> {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    /**
     * Creates a new warehouse.
     *
     * @param warehouseDto The DTO containing data for the new warehouse
     * @return The DTO representing the created warehouse
     */
    @Override
    public WarehouseDto createEntity(WarehouseDto warehouseDto) {
        Warehouse warehouse = mapToEntity(warehouseDto);
        Warehouse newWarehouse = warehouseRepository.save(warehouse);
        return mapToDto(newWarehouse);
    }

    /**
     * Retrieves all warehouses.
     *
     * @return A list of DTOs representing all warehouses
     */
    @Override
    public List<WarehouseDto> getAllEntities() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return warehouses.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    /**
     * Retrieves a warehouse by its ID.
     *
     * @param id The ID of the warehouse to retrieve
     * @return The DTO representing the retrieved warehouse
     * @throws ResourceNotFoundException if the warehouse with the given ID is not found
     */
    @Override
    public WarehouseDto getEntityById(long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        return mapToDto(warehouse);
    }

    /**
     * Updates an existing warehouse.
     *
     * @param warehouseDto The DTO containing updated data for the warehouse
     * @param id           The ID of the warehouse to update
     * @return The DTO representing the updated warehouse
     * @throws ResourceNotFoundException if the warehouse with the given ID is not found
     */
    @Override
    public WarehouseDto updateEntity(WarehouseDto warehouseDto, long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));

        warehouse.setName(warehouseDto.getName());
        warehouse.setLocation(warehouseDto.getLocation());

        Warehouse updatedWarehouse = warehouseRepository.save(warehouse);
        return mapToDto(updatedWarehouse);
    }

    /**
     * Deletes a warehouse by its ID.
     *
     * @param id The ID of the warehouse to delete
     * @throws ResourceNotFoundException if the warehouse with the given ID is not found
     */
    @Override
    public void deleteEntityById(long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        warehouseRepository.delete(warehouse);
    }

    /**
     * Maps a Warehouse entity to a WarehouseDto.
     *
     * @param warehouse The Warehouse entity
     * @return The corresponding WarehouseDto
     */
    private WarehouseDto mapToDto(Warehouse warehouse) {
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setId(warehouse.getId());
        warehouseDto.setName(warehouse.getName());
        warehouseDto.setLocation(warehouse.getLocation());
        return warehouseDto;
    }

    /**
     * Maps a WarehouseDto to a Warehouse entity.
     *
     * @param warehouseDto The WarehouseDto
     * @return The corresponding Warehouse entity
     */
    private Warehouse mapToEntity(WarehouseDto warehouseDto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehouse.setLocation(warehouseDto.getLocation());
        return warehouse;
    }
}
