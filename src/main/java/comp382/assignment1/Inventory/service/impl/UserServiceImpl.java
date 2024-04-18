package comp382.assignment1.Inventory.service.impl;


import comp382.assignment1.Inventory.dto.UserDto;
import comp382.assignment1.Inventory.entity.User;
import comp382.assignment1.Inventory.exception.ResourceNotFoundException;
import comp382.assignment1.Inventory.repository.UserRepository;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing user-related operations.
 * This class implements the EntityService interface for generic CRUD operations on User entities.
 */
@Service
public class UserServiceImpl implements EntityService<User, UserDto> {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user.
     *
     * @param userDto The DTO containing data for the new user
     * @return The DTO representing the created user
     */
    @Override
    public UserDto createEntity(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        return mapToDto(newUser);
    }

    /**
     * Retrieves all users.
     *
     * @return A list of DTOs representing all users
     */
    @Override
    public List<UserDto> getAllEntities() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve
     * @return The DTO representing the retrieved user
     * @throws ResourceNotFoundException if the user with the given ID is not found
     */
    @Override
    public UserDto getEntityById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDto(user);
    }

    /**
     * Updates an existing user.
     *
     * @param userDto The DTO containing updated data for the user
     * @param id      The ID of the user to update
     * @return The DTO representing the updated user
     * @throws ResourceNotFoundException if the user with the given ID is not found
     */
    @Override
    public UserDto updateEntity(UserDto userDto, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete
     * @throws ResourceNotFoundException if the user with the given ID is not found
     */
    @Override
    public void deleteEntityById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    /**
     * Maps a User entity to a UserDto.
     *
     * @param user The User entity
     * @return The corresponding UserDto
     */
    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    /**
     * Maps a UserDto to a User entity.
     *
     * @param userDto The UserDto
     * @return The corresponding User entity
     */
    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
