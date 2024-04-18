package comp382.assignment1.Inventory.service.impl;

import comp382.assignment1.Inventory.dto.OrderDto;
import comp382.assignment1.Inventory.entity.Order;
import comp382.assignment1.Inventory.exception.ResourceNotFoundException;
import comp382.assignment1.Inventory.repository.OrderRepository;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing order-related operations.
 * This class implements the EntityService interface for generic CRUD operations on Order entities.
 */
@Service
public class OrderServiceImpl implements EntityService<Order, OrderDto> {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Creates a new order.
     *
     * @param orderDto The DTO containing data for the new order
     * @return The DTO representing the created order
     */
    @Override
    public OrderDto createEntity(OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        Order newOrder = orderRepository.save(order);
        return mapToDto(newOrder);
    }

    /**
     * Retrieves all orders.
     *
     * @return A list of DTOs representing all orders
     */
    @Override
    public List<OrderDto> getAllEntities() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id The ID of the order to retrieve
     * @return The DTO representing the retrieved order
     * @throws ResourceNotFoundException if the order with the given ID is not found
     */
    @Override
    public OrderDto getEntityById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return mapToDto(order);
    }

    /**
     * Updates an existing order.
     *
     * @param orderDto The DTO containing updated data for the order
     * @param id       The ID of the order to update
     * @return The DTO representing the updated order
     * @throws ResourceNotFoundException if the order with the given ID is not found
     */
    @Override
    public OrderDto updateEntity(OrderDto orderDto, long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        order.setProductId(orderDto.getProductId());
        order.setQuantity(orderDto.getQuantity());
        order.setStatus(orderDto.getStatus());

        Order updatedOrder = orderRepository.save(order);
        return mapToDto(updatedOrder);
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id The ID of the order to delete
     * @throws ResourceNotFoundException if the order with the given ID is not found
     */
    @Override
    public void deleteEntityById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        orderRepository.delete(order);
    }

    /**
     * Maps an Order entity to an OrderDto.
     *
     * @param order The Order entity
     * @return The corresponding OrderDto
     */
    private OrderDto mapToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setProductId(order.getProductId());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

    /**
     * Maps an OrderDto to an Order entity.
     *
     * @param orderDto The OrderDto
     * @return The corresponding Order entity
     */
    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setProductId(orderDto.getProductId());
        order.setQuantity(orderDto.getQuantity());
        order.setStatus(orderDto.getStatus());
        return order;
    }
}
