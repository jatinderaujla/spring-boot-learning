package com.example.demo;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public User saveUser(User user){
        user.setId(new Random().nextInt(100));
        users.add(user);
        return user;
    }

    public User updateUser(Integer userId, User user){
        User existingUser = null;
        for (int i = 0; i < users.size(); i++) {
            if(Objects.equals(userId, users.get(i).getId())){
                existingUser = users.get(i);
            }
        }
        if(existingUser != null){
            existingUser.setAge(user.getAge());
            existingUser.setName(user.getName());
            return existingUser;
        }
        throw new RuntimeException("User does not exists for id: "+ userId);
    }

    public String deleteUser(Integer userId){
        User existingUser = null;
        for (int i = 0; i < users.size(); i++) {
            if(userId == users.get(i).getId()){
                existingUser = users.get(i);
            }
        }
        if(existingUser != null){
            users.remove(existingUser);
            return "User deleted successfully";
        }
        throw new RuntimeException("User does not exists for id: "+ userId);
    }

    public User updateUserAge(Integer userId, Integer age){
        User existingUser = null;
        for (int i = 0; i < users.size(); i++) {
            if(userId == users.get(i).getId()){
                existingUser = users.get(i);
            }
        }
        if(existingUser != null){
            existingUser.setAge(age);
            return existingUser;
        }
        throw new RuntimeException("User does not exists for id: "+ userId);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> GetUsername(String name)
    {
        List <User> existingusers = new ArrayList<>();

            for (int i = 0; i < users.size(); i++)
            {

                User user = users.get(i);

                if ( name.equals(user.getName()) )
                {
                  existingusers.add(user);

                }
            }

            return existingusers;
    }

    public User getuserDeatils (Integer a)
    {
        User Jojo = null;
        for (int i = 0; i < users.size(); i++)
        {
            User newuser = users.get(i);

            if ( newuser.getId() == a)
            {
                Jojo = newuser;

            }
        }

        if (Jojo == null)
        {
            throw new RuntimeException("USer not Exist"+a);
        }

        return Jojo;

    }
}
