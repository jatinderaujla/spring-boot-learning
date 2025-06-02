package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/user")
public class HelloController {

//    @Autowired
    private UserService userService;
//

//    public HelloController(UserService userService){
//      this.userService = userService;
//    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //-> http://locahost:8080/printNameAndAge?name=john&age=20
//    @GetMapping
    @GetMapping
    public String helo(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age){
        return "Hello "+name +" You age is "+ age;
    }

    //-> http://locahost:8080/printNameAndAge/john
//    @GetMapping("printName/{name}")
//    public String helo23(@PathVariable(value = "name") String name){
//        return "Hello "+name;
//    }

    //-> http://locahost:8080/saveUser
    @PostMapping
    public String hello2(@RequestBody Hello hello){
        return "Hello "+hello.getName() +" You age is "+ hello.getAge();
    }

    //-> http://locahost:8080/updateUser/101
    @PutMapping
    public String test(@PathVariable("userId") String userId, @RequestBody Hello hello){
        return "UserId" + userId +"Hello "+hello.getName() +" You age is "+ hello.getAge();
    }

    @DeleteMapping
    public String test2(@PathVariable("userId") String userId, @RequestBody Hello hello){
        return "UserId" + userId +"Hello "+hello.getName() +" You age is "+ hello.getAge();
    }

    @PatchMapping
    public String test3(@PathVariable("userId") String userId, @RequestBody Hello hello){
        return "UserId" + userId +"Hello "+hello.getName() +" You age is "+ hello.getAge();
    }
}
