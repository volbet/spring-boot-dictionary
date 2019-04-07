package com.concurrency.example.service.api;

import com.concurrency.example.model.BanZach;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanZachAPI {

    public BanZach getBanZach(String id) {
        System.out.println("BanZach(id =  " + id + ")");
        return new BanZach("1", "Test");
    }

    public List<BanZach> getAllBanZach() {
        List<BanZach> allBanZach = new ArrayList<>();
        allBanZach.add(new BanZach("1", "Test"));
        allBanZach.add(new BanZach("2", "Test2"));
        allBanZach.add(new BanZach("3", "Test3"));
        allBanZach.add(new BanZach("4", "Test4"));
        allBanZach.add(new BanZach("5", "Test5"));
        allBanZach.add(new BanZach("6", "Test6"));
        return allBanZach;
    }
}
