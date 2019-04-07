package com.concurrency.example.service.async;

import java.util.concurrent.CompletableFuture;

public interface DictionaryAsyncService {

    CompletableFuture<Void> loadAllTerBank();
    CompletableFuture<Void> loadAllBanZach();
}
