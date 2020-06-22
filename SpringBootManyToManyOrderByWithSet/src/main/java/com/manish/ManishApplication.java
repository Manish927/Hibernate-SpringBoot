
package com.manish;

import com.manish.service.DeviceStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManishApplication {

    @Autowired
    private DeviceStoreService deviceStoreService;

    public static void main(String[] args) {
        SpringApplication.run(ManishApplication.class, args);
    }

    @Bean
    public ApplicationRunner init()
    {
        return args -> {
            System.out.println("Insert Data to Table");
            deviceStoreService.insertUserWithDevice();

            System.out.println("Fetch users of device in order");
            deviceStoreService.fetchUsersOfDevice();
        };
    }
}
