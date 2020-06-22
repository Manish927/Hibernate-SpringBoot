package com.manish.service;

import com.manish.entity.Device;
import com.manish.entity.User;
import com.manish.repository.DeviceRepository;
import com.manish.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Set;

@Service
public class DeviceStoreService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    public DeviceStoreService(DeviceRepository deviceRepository, UserRepository userRepository) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void fetchUsersOfDevice()
    {
        Device device = deviceRepository.findById(5L).get();
        Set<User> userSet = device.getUsers();
        System.out.println("Users ordered descending by name: \n" + userSet.size() + userSet);
    }

    @Transactional
    public void insertUserWithDevice()
    {
        User user1 = new User();
        user1.setName("Manish Srivastava1");
        user1.setAge(33);
        user1.setAddress("106 Pune India");

        User user2 = new User();
        user2.setName("Jacqueline Long");
        user2.setAge(44);
        user2.setAddress("1497 Yuzhou Drive");

        Device device1 = new Device();
        device1.setName("iPhone X");
        device1.setModel("002-JN");
        device1.setArchitecture("IOS x86_64");
        device1.setLaunch(new Date(2020-1-30));

        Device device2 = new Device();
        device1.setName("iPhone 5s");
        device1.setModel("001-MJ");
        device1.setArchitecture("IOS x86_64");
        device1.setLaunch(new Date(2015-1-30));

        user1.addDevice(device1);
        user2.addDevice(device2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
