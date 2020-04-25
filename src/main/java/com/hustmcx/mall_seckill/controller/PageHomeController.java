package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.ProductDetail;
import com.hustmcx.mall_seckill.model.ProductInfo;
import com.hustmcx.mall_seckill.service.ProductDetailService;
import com.hustmcx.mall_seckill.service.ProductService;
import com.hustmcx.mall_seckill.vo.productInfo.CustomProduct;
import com.hustmcx.mall_seckill.vo.productInfo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pageHome")
public class PageHomeController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping("/home")
    public String toPageHome(Model model) {
        ProductInfoVo productInfoVo = new ProductInfoVo();
        CustomProduct customProduct = new CustomProduct();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowString = dateFormat.format(now);
        customProduct.setStartEndTime("2020-04-01");
        customProduct.setAuditState(2);
        productInfoVo.setCustomProduct(customProduct);
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
        List<ProductInfo> list = productService.listProduct(productInfoVo);
        model.addAttribute("list", list);
        return "/homePage/home";
    }


    @RequestMapping("/viewProductDetail")
    public String viewProductDetail(Model model, int productId) {
        ProductInfo productInfo = productService.queryProductByProductId(productId);
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(productId);
        model.addAttribute("productInfo", productInfo);
        model.addAttribute("productDetail", productDetail);
        return "/order/sellDetail";
    }
}
