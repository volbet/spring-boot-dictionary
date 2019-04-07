package com.concurrency.example.service;

import com.concurrency.example.constant.CacheDictionary;
import com.concurrency.example.model.BanZach;
import com.concurrency.example.service.api.BanZachAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BanZachServiceImpl implements BanZachService {

    private final BanZachAPI banZachAPI;

    @Autowired
    public BanZachServiceImpl(BanZachAPI banZachAPI) {
        this.banZachAPI = banZachAPI;
    }

    @Override
    @Cacheable(value = CacheDictionary.BAN_ZACH_CACHE_NAME, key = "#id")
    public BanZach loadBanZach(String id) {
        return banZachAPI.getBanZach(id);
    }
}
