package com.concurrency.example.service;

import com.concurrency.example.constant.CacheDictionary;
import com.concurrency.example.model.TerBank;
import com.concurrency.example.service.api.TerBankAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TerBankServiceImpl implements TerBankService {

    private final TerBankAPI terBankAPI;

    @Autowired
    public TerBankServiceImpl(TerBankAPI terBankAPI) {
        this.terBankAPI = terBankAPI;
    }

    @Override
    @Cacheable(value = CacheDictionary.TER_BANK_CACHE_NAME, key = "#id")
    public TerBank loadTerbank(String id) {
        return terBankAPI.getTerBank(id);
    }
}
