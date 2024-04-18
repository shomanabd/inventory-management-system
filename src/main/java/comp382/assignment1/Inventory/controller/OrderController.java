package comp382.assignment1.Inventory.controller;

import comp382.assignment1.Inventory.dto.OrderDto;
import comp382.assignment1.Inventory.entity.Order;
import comp382.assignment1.Inventory.service.EntityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling order-related operations.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final EntityService<Order, OrderDto> orderService;

    public OrderController(EntityService<Order, OrderDto> orderService) {
        this.orderService = orderService;
    }

    /**
     * Endpoint to retrieve all orders.
     *
     * @return ResponseEntity containing a list of OrderDto representing all orders
     */
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllEntities());
    }

    /**
     * Endpoint to retrieve an order by its ID.
     *
     * @param id The ID of the order to retrieve
     * @return ResponseEntity containing the OrderDto representing the retrieved order
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable long id) {
        return ResponseEntity.ok().body(orderService.getEntityById(id));
    }

    /**
     * Endpoint to create a new order.
     *
     * @param orderDto The OrderDto containing data for the new order
     * @return ResponseEntity containing the created OrderDto
     */
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createEntity(orderDto));
    }

    /**
     * Endpoint to update an existing order.
     *
     * @param id       The ID of the order to update
     * @param orderDto The OrderDto containing updated data for the order
     * @return ResponseEntity containing the updated OrderDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable long id, @Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().body(orderService.updateEntity(orderDto, id) );
    }

    /**
     * Endpoint to delete an order by its ID.
     *
     * @param id The ID of the order to delete
     * @return ResponseEntity with status OK if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        orderService.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}
