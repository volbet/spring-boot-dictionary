package com.concurrency.example.service.sync;

import com.concurrency.example.model.BanZach;
import com.concurrency.example.model.TerBank;

import java.util.List;

public interface DictionaryService {

    List<TerBank> loadAllTerbank();
    List<BanZach> loadAllBanZach();
}
