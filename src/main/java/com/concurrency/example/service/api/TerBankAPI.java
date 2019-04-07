package com.concurrency.example.service.api;

import com.concurrency.example.model.TerBank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerBankAPI {

    public TerBank getTerBank(String id) {
        return new TerBank("1", "Test");
    }

    public List<TerBank> getAllTerBank() {
        List<TerBank> allTerBank = new ArrayList<>();
        allTerBank.add(new TerBank("1", "Test"));
        allTerBank.add(new TerBank("2", "Test2"));
        allTerBank.add(new TerBank("3", "Test3"));
        allTerBank.add(new TerBank("4", "Test4"));
        allTerBank.add(new TerBank("5", "Test5"));
        allTerBank.add(new TerBank("6", "Test6"));
        return allTerBank;
    }
}
