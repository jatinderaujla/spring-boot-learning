package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){
        return userService.deleteUser(userId);
    }

    @PatchMapping("{userId}")
    public User updateUserAge(@PathVariable("userId") Integer userId, @RequestParam("age") Integer age){
        return userService.updateUserAge(userId, age);
    }

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("search")
    public List<User> fetchUserName(@RequestParam ("name") String name)
    {
       return userService.GetUsername(name);
    }

    @GetMapping("{userID}")
    public User username (@PathVariable ("userID") Integer id)
    {
        return userService.getuserDeatils(id);
    }





}