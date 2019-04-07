package com.concurrency.example.service.async;

import com.concurrency.example.constant.CacheDictionary;
import com.concurrency.example.model.BanZach;
import com.concurrency.example.model.TerBank;
import com.concurrency.example.service.sync.DictionaryService;
import com.concurrency.example.service.sync.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class DictionaryAsyncServiceImpl implements DictionaryAsyncService {

    private final DictionaryService dictionaryService;
    private final CacheManager cacheManager;
    private final Executor executor;

    @Autowired
    public DictionaryAsyncServiceImpl(DictionaryService dictionaryService, CacheManager cacheManager, Executor executor) {
        this.dictionaryService = dictionaryService;
        this.cacheManager = cacheManager;
        this.executor = executor;
    }

    public CompletableFuture<Void> loadAllTerBank() {
        CompletableFuture<List<TerBank>> completableFuture = new CompletableFuture<>();
        return completableFuture.thenApplyAsync(terBanks -> dictionaryService.loadAllTerbank(), executor)
                .thenAcceptAsync(terBanks -> terBanks.forEach(terBank -> {
                    cacheManager.getCache(CacheDictionary.TER_BANK_CACHE_NAME).put(terBank.getId(), terBank);
                }));
    }

    @Override
    public CompletableFuture<Void> loadAllBanZach() {
        CompletableFuture<List<BanZach>> completableFuture = new CompletableFuture<>();
        return completableFuture.thenApplyAsync(banZaches -> dictionaryService.loadAllBanZach(), executor)
                .thenAcceptAsync(banZaches -> banZaches.forEach(banZach -> {
                    cacheManager.getCache(CacheDictionary.BAN_ZACH_CACHE_NAME).put(banZach.getId(), banZach);
                }));
    }
}
