package com.hustmcx.mall_seckill.service.pay;

public interface OrderToPay {

    /**
     * @param transactionSerial
     * @param payAmount
     * @return 1 代表支付成功 2，代表支付失败
     */
    int payWithOrder(String transactionSerial, int payAmount);

    /**
     * 退款
     *
     * @param transactionSerial
     * @param payAmount
     * @return 1 代表支付成功 2，代表支付失败
     */
    int refundWithOrder(String transactionSerial, int payAmount);
}
