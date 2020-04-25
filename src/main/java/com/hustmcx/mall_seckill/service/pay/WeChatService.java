package com.hustmcx.mall_seckill.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WeChatService implements OrderToPay {
    @Override
    public int payWithOrder(String transactionSerial, int payAmount) {
        System.out.println("微信支付成功");
        return 1;
    }

    @Override
    public int refundWithOrder(String transactionSerial, int payAmount) {
        System.out.println("微信退款成功");
        return 1;
    }
}
