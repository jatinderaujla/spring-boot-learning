package com.example.demo;

public class MainClass {
    public static void main(String[] args) {
        UserService userService = new UserService();
        HelloController helloController = new HelloController();
//        helloController.setUserService(userService);
        helloController.hello2(new Hello());
    }
}
