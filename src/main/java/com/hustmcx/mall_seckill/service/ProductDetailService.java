package com.hustmcx.mall_seckill.service;

import com.hustmcx.mall_seckill.dao.ProductDetailDao;
import com.hustmcx.mall_seckill.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailDao productDetailDao;

    public void insertProductDetail(ProductDetail productDetail) {
        productDetailDao.insertProductDetail(productDetail);
    }

    public ProductDetail queryProductDetailByProductId(int productId) {
        return productDetailDao.queryProductDetailByProductId(productId);
    }

    public void updateProductDetail(ProductDetail productDetail) {
        productDetailDao.updateProductDetail(productDetail);
    }
}
