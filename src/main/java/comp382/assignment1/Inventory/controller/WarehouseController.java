package comp382.assignment1.Inventory.controller;

import comp382.assignment1.Inventory.dto.WarehouseDto;
import comp382.assignment1.Inventory.entity.Warehouse;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling warehouse-related operations.
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final EntityService<Warehouse, WarehouseDto> warehouseService;

    public WarehouseController(EntityService<Warehouse, WarehouseDto> warehouseService) {
        this.warehouseService = warehouseService;
    }

    /**
     * Endpoint to retrieve all warehouses.
     *
     * @return ResponseEntity containing a list of WarehouseDto representing all warehouses
     */
    @GetMapping
    public ResponseEntity<List<WarehouseDto>> getAllWarehouses() {
        return ResponseEntity.ok().body(warehouseService.getAllEntities());
    }

    /**
     * Endpoint to retrieve a warehouse by its ID.
     *
     * @param id The ID of the warehouse to retrieve
     * @return ResponseEntity containing the WarehouseDto representing the retrieved warehouse
     */
    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDto> getWarehouseById(@PathVariable long id) {
        return ResponseEntity.ok().body(warehouseService.getEntityById(id));
    }

    /**
     * Endpoint to create a new warehouse.
     *
     * @param warehouseDto The WarehouseDto containing data for the new warehouse
     * @return ResponseEntity containing the created WarehouseDto
     */
    @PostMapping
    public ResponseEntity<WarehouseDto> createWarehouse(@RequestBody WarehouseDto warehouseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.createEntity(warehouseDto));
    }

    /**
     * Endpoint to update an existing warehouse.
     *
     * @param id            The ID of the warehouse to update
     * @param warehouseDto The WarehouseDto containing updated data for the warehouse
     * @return ResponseEntity containing the updated WarehouseDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<WarehouseDto> updateWarehouse(@PathVariable long id, @RequestBody WarehouseDto warehouseDto) {
        return ResponseEntity.ok().body(warehouseService.updateEntity(warehouseDto, id));
    }

    /**
     * Endpoint to delete a warehouse by its ID.
     *
     * @param id The ID of the warehouse to delete
     * @return ResponseEntity with status OK if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable long id) {
        warehouseService.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}
