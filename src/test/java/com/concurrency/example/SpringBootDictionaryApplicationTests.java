package com.concurrency.example;

import com.concurrency.example.service.BanZachService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDictionaryApplicationTests {

    @Autowired
    private BanZachService banZachService;

    @Test
    public void contextLoads() {
        banZachService.loadBanZach("1");
        banZachService.loadBanZach("1");
        banZachService.loadBanZach("1");
    }

}
