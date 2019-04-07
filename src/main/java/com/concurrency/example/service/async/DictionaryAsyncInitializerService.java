package com.concurrency.example.service.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CompletableFuture;

@Service
public class DictionaryAsyncInitializerService {

    private final DictionaryAsyncService dictionaryAsyncService;

    @Autowired
    public DictionaryAsyncInitializerService(DictionaryAsyncService dictionaryAsyncService) {
        this.dictionaryAsyncService = dictionaryAsyncService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Загрузка справочников в асинхроном режиме");
        CompletableFuture.allOf(dictionaryAsyncService.loadAllBanZach(),
                dictionaryAsyncService.loadAllTerBank());
        System.out.println("Загрузка окончена в асинхроном режиме");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Очистка справочников в асинхроном режиме");
        //cacheManager.getCacheNames().clear();
        System.out.println("Очистка закончена в асинхроном режиме");
    }
}
