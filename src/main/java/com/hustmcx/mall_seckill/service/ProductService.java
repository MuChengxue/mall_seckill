package com.hustmcx.mall_seckill.service;

import com.hustmcx.mall_seckill.dao.ProductInfoDao;
import com.hustmcx.mall_seckill.model.ProductInfo;
import com.hustmcx.mall_seckill.vo.productInfo.CustomProduct;
import com.hustmcx.mall_seckill.vo.productInfo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductInfoDao productInfoDao;

    /**
     * 申请（添加）秒杀商品
     *
     * @param productInfo
     */
    public void applySkProduct(ProductInfo productInfo) {
        String startTime = productInfo.getStartTimeString();//
        String endTime = productInfo.getEndTimeString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTimeDate = dateFormat.parse(startTime);
            productInfo.setStartTime(startTimeDate);
            Date endTimeDate = dateFormat.parse(endTime);
            productInfo.setEndTime(endTimeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        productInfo.setApplyTime(new Date());//申请时间就是现在
        productInfo.setAuditState(1);
        System.out.println(productInfo);
        productInfoDao.applySkProduct(productInfo);
    }

    /**
     * 秒杀商品列表
     *
     * @param productInfoVo
     */
    public List<ProductInfo> listProduct(ProductInfoVo productInfoVo) {
        return productInfoDao.listProduct(productInfoVo);
    }

    /**
     * 根据秒杀商品id查询秒杀商品
     *
     * @param id
     */
    public ProductInfo queryProductByProductId(int id) {
        return productInfoDao.queryProductByProductId(id);
    }

    public void deleteProductByProductId(int id) {
        productInfoDao.deleteProductByProductId(id);
    }

    public void updateProduct(ProductInfo productInfo) {
        String startTime = productInfo.getStartTimeString();
        String endTime = productInfo.getEndTimeString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTimeDate = dateFormat.parse(startTime);
            productInfo.setStartTime(startTimeDate);
            Date endTimeDate = dateFormat.parse(endTime);
            productInfo.setEndTime(endTimeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        productInfoDao.updateProduct(productInfo);
    }

    /**
     * 跟新转态
     *
     * @param id
     * @param state
     */
    public void updateProductState(int id, int state) {
        ProductInfoVo productInfoVo = new ProductInfoVo();
        CustomProduct customProduct = new CustomProduct();
        customProduct.setId(id);
        customProduct.setAuditState(state);
        productInfoVo.setCustomProduct(customProduct);
        productInfoDao.updateProductState(productInfoVo);
    }
}
