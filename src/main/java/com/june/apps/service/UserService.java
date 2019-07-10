package com.june.apps.service;

import com.june.customerwsdlmodel.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User park = new User();
        park.setName("NinaPark");
        park.setCustId(1111);
        park.setOD(12000);

        User bullock = new User();
        bullock.setName("BullockGriffith");
        bullock.setCustId(1112);
        bullock.setOD(32000);
        
        User drew = new User();
        drew.setName("BarronAndrews");
        drew.setCustId(1113);
        drew.setOD(16000);

        users.put(park.getName(), park);
        users.put(bullock.getName(), bullock);
        users.put(drew.getName(), drew);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}
