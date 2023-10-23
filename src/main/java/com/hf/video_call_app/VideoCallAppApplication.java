package com.hf.video_call_app;

import com.hf.video_call_app.user.User;
import com.hf.video_call_app.user.UserService.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoCallAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner( UserService service) {
        return args -> {
            service.RegisterUser(User.builder().
                    username("Hsen")
                            .email("hsen@gmail.com")
                            .password("AAA")
                    .build());
            service.RegisterUser(User.builder().
                    username("Ali")
                    .email("Ali@gmail.com")
                    .password("AAA")
                    .build());
            service.RegisterUser(User.builder().
                    username("Elie")
                    .email("Elie@gmail.com")
                    .password("AAA")
                    .build());
        };
    }
}
