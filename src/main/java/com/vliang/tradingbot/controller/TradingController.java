package com.vliang.tradingbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vliang.tradingbot.service.AlpacaService;
import com.vliang.tradingbot.service.TradingService;

@RestController
public class TradingController {

    @Autowired
    private TradingService tradingService;

    @Autowired
    private AlpacaService alpacaService;

    @GetMapping("/trade")
    public String trade() {
        tradingService.executeTrade();
        return "Trade executed";
    }

    @GetMapping("/account-info")
    public String getMethodName() {
        return alpacaService.getAccountInfo();
    }

}
