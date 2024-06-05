package jordhan.felix.todolist_backend.controller;


import jordhan.felix.todolist_backend.controller.Dto.InputUserDto;
import jordhan.felix.todolist_backend.entity.User;
import jordhan.felix.todolist_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<User> create(@RequestBody InputUserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(user));
    }

   @GetMapping
   List<User> list() {
      return userService.list();
    }

    @GetMapping("{id}")
    ResponseEntity<User> find(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.find(id));
    }

    @PutMapping("{id}")
    ResponseEntity<User> update(@PathVariable Long id, @RequestBody InputUserDto user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(id ,user));
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
