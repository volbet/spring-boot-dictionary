package com.concurrency.example.service.sync;

import com.concurrency.example.model.BanZach;
import com.concurrency.example.model.TerBank;
import com.concurrency.example.service.api.BanZachAPI;
import com.concurrency.example.service.api.TerBankAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final BanZachAPI banZachAPI;
    private final TerBankAPI terBankAPI;

    @Autowired
    public DictionaryServiceImpl(BanZachAPI banZachAPI, TerBankAPI terBankAPI) {
        this.banZachAPI = banZachAPI;
        this.terBankAPI = terBankAPI;
    }

    @Override
    public List<TerBank> loadAllTerbank() {
        return terBankAPI.getAllTerBank();
    }

    @Override
    public List<BanZach> loadAllBanZach() {
        return banZachAPI.getAllBanZach();
    }
}
