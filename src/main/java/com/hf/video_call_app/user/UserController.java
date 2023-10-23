package com.hf.video_call_app.user;

import com.hf.video_call_app.user.UserService.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
//Not recommended for production environments
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public void RegisterUser(User user) {
        userService.RegisterUser(user);
    }


    @PostMapping("/login")
    public User Login(User user){
        return userService.Login(user);
    }
    @PostMapping("/logout")
    public void LogOut(String email){
       userService.LogOut(email);
    }
    @GetMapping
    public List<User> listUsers(){
       return userService.listUsers();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Error: ", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
