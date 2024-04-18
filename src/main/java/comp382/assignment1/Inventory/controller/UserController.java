package comp382.assignment1.Inventory.controller;

import comp382.assignment1.Inventory.dto.UserDto;
import comp382.assignment1.Inventory.entity.User;
import comp382.assignment1.Inventory.service.EntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final EntityService<User, UserDto> userService;

    public UserController(EntityService<User, UserDto> userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to retrieve all users.
     *
     * @return ResponseEntity containing a list of UserDto representing all users
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllEntities());
    }

    /**
     * Endpoint to retrieve a user by its ID.
     *
     * @param id The ID of the user to retrieve
     * @return ResponseEntity containing the UserDto representing the retrieved user
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.getEntityById(id));
    }

    /**
     * Endpoint to create a new user.
     *
     * @param userDto The UserDto containing data for the new user
     * @return ResponseEntity containing the created UserDto
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createEntity(userDto));
    }

    /**
     * Endpoint to update an existing user.
     *
     * @param id      The ID of the user to update
     * @param userDto The UserDto containing updated data for the user
     * @return ResponseEntity containing the updated UserDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.updateEntity(userDto, id));
    }

    /**
     * Endpoint to delete a user by its ID.
     *
     * @param id The ID of the user to delete
     * @return ResponseEntity with status OK if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}
