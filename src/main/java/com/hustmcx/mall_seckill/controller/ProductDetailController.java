package com.hustmcx.mall_seckill.controller;


import com.hustmcx.mall_seckill.model.ProductDetail;
import com.hustmcx.mall_seckill.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("productDetail")
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(value = "/toInsertProductDetail")
    public String toInsertProductDetail(Model model, int productId, int sellerId) {
        model.addAttribute("productId", productId);
        model.addAttribute("sellerId", sellerId);
        return "/productDetail/toInsertProductDetail";
    }

    @RequestMapping(value = "/insertProductDetail", method = RequestMethod.POST)
    public String insertProductDetail(ProductDetail productDetail) {
        productDetailService.insertProductDetail(productDetail);
        return "redirect:/SkProduct/listSkProduct";
    }

    @RequestMapping(value = "/queryProductDetailByProductId")
    public String queryProductDetailByProductId(Model model, int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(productId);
        model.addAttribute("productDetail", productDetail);
        return "/productDetail/productDetailView";
    }

    @RequestMapping(value = "/toUpdateProductDetail")
    public String toUpdateProductDetail(Model model, int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailByProductId(productId);
        model.addAttribute("productDetail", productDetail);
        return "/productDetail/toUpdateProductDetail";
    }

    @RequestMapping(value = "/updateProductDetail", method = RequestMethod.GET)
    public String updateProductDetail(ProductDetail productDetail) {
        productDetailService.updateProductDetail(productDetail);
        return "redirect:/SkProduct/listSkProduct";
    }
}
