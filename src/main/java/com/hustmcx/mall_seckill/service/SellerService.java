package com.hustmcx.mall_seckill.service;

import com.hustmcx.mall_seckill.dao.SellerDao;
import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.vo.seller.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerDao sellerDao;

    public void insertSeller(Seller seller) {
        sellerDao.insertSeller(seller);
    }

    public Seller getSellerById(int id) {
        return sellerDao.getSellerById(id);
    }

    public void updateSeller(Seller seller) {
        sellerDao.updateSeller(seller);
    }

    public void deleteSellerById(int id) {
        sellerDao.deleteSellerById(id);
    }

    public List<Seller> querySellerByVo(SellerVo sellerVo) {
        return sellerDao.querySellerByVo(sellerVo);
    }

    public Seller getSellerByAccount(String account) {
        return sellerDao.getSellerByAccount(account);
    }

}
