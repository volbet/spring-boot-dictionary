package com.concurrency.example.service.scheduled;

import com.concurrency.example.service.async.DictionaryAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DictionaryScheduledServiceImpl implements DictionaryScheduledService {

    private final DictionaryAsyncService dictionaryAsyncService;

    @Autowired
    public DictionaryScheduledServiceImpl(DictionaryAsyncService dictionaryAsyncService) {
        this.dictionaryAsyncService = dictionaryAsyncService;
    }

    @Override
    @Scheduled(fixedRate = 5000)
    public void updateDictionary() {
        System.out.println("Загрузка справочников в асинхроном режиме через планировщик");
        CompletableFuture.allOf(dictionaryAsyncService.loadAllBanZach(),
                dictionaryAsyncService.loadAllTerBank());
        System.out.println("Загрузка окончена в асинхроном режиме через планировщик");
    }
}
