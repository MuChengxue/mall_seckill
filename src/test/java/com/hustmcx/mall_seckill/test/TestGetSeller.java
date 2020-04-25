package com.hustmcx.mall_seckill.test;

import com.hustmcx.mall_seckill.MallSeckillApplication;
import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallSeckillApplication.class)
public class TestGetSeller {

    @Autowired
    SellerService sellerService;

    @Test
    public void testGetSeller() {
        Seller seller = sellerService.getSellerById(5);
        System.out.println(seller);
    }
}
