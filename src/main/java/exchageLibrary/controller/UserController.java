package exchageLibrary.controller;

import exchageLibrary.model.entity.User;
import exchageLibrary.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private IUser userService;

    @PostMapping(path = "user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(path = "user")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping(path = "user/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(userService.findById(id));
    }

    @GetMapping(path = "user/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "users")
    public List<User> findAll(){
        return userService.findAll();
    }

}
