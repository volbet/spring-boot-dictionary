package com.concurrency.example.service.sync;

import com.concurrency.example.constant.CacheDictionary;
import com.concurrency.example.model.BanZach;
import com.concurrency.example.model.TerBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class DictionaryInitializerService {

    private final CacheManager cacheManager;
    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryInitializerService(CacheManager cacheManager, DictionaryService dictionaryService) {
        this.cacheManager = cacheManager;
        this.dictionaryService = dictionaryService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Загрузка справочников");
        List<BanZach> banZaches = dictionaryService.loadAllBanZach();
        List<TerBank> terBanks = dictionaryService.loadAllTerbank();
        banZaches.forEach(banZach -> cacheManager.getCache(CacheDictionary.BAN_ZACH_CACHE_NAME).put(banZach.getId(), banZach));
        terBanks.forEach(terBank -> cacheManager.getCache(CacheDictionary.TER_BANK_CACHE_NAME).put(terBank.getId(), terBank));
        System.out.println("Загрузка окончена");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Очистка справочников");
        //cacheManager.getCacheNames().clear();
        System.out.println("Очистка закончена");
    }
}
