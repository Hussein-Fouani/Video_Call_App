package com.hf.video_call_app.user.UserService;

import com.hf.video_call_app.user.User;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_List = new ArrayList<>();

    //Register a new user
    //set the user status to online
    //add the user to the list of users
    public void RegisterUser(User user) {
        user.setStatus("ONLINE");
        USERS_List.add(user);
    }

    //Iterate through the list of users and find the user index along his email to check if email is already registered
    //if not found the user hadn't registered yet
    //If the user exists, check if the password is correct
    //If the password is correct, set the user status to online
    //If the password is wrong, throw an exception
    public User Login(User user){
        var userIndex = IntStream.range(0, USERS_List.size())
                .filter(i -> USERS_List.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));
        var Cuser = USERS_List.get(userIndex);
        if(!Cuser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        Cuser.setStatus("ONLINE");
        return Cuser;
    }
    public void LogOut(String email){
        var userIndex = IntStream.range(0, USERS_List.size())
                .filter(i -> USERS_List.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));
        USERS_List.get(userIndex).setStatus("OFFLINE");
    }
    public List<User> listUsers(){
        return USERS_List;
    }
}
