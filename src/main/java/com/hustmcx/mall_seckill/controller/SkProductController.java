package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.ProductInfo;
import com.hustmcx.mall_seckill.service.ProductService;
import com.hustmcx.mall_seckill.vo.productInfo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/SkProduct")
public class SkProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/toApplySkProduct")
    public String toApplySkProduct() {
        return "skProductInfo/applySkProduct";
    }

    @RequestMapping(value = "/applySkProduct", method = RequestMethod.POST)
    public String applySkProduct(ProductInfo productInfo) {
        System.out.println("applySkProduct");
        productService.applySkProduct(productInfo);
        System.out.println(productInfo);
        return "redirect:listSkProduct";
    }

    @RequestMapping(value = "/listSkProduct")
    public String listSkProduct(Model model, ProductInfoVo productInfoVo) {
        List<ProductInfo> list = productService.listProduct(productInfoVo);
        model.addAttribute("list", list);
        return "/skProductInfo/list";
    }

    @RequestMapping(value = "/queryProductByIid")
    public String queryProductByIid(Model model, int productId) {
        ProductInfo productInfo = productService.queryProductByProductId(productId);
        model.addAttribute("productInfo", productInfo);
        return "/skProductInfo/view";
    }

    @RequestMapping(value = "/deleteProductById")
    public String deleteProductById(int productId) {
        productService.deleteProductByProductId(productId);
        return "redirect:listSkProduct";
    }

    @RequestMapping(value = "/toUpdateProduct")
    public String toUpdateProduct(Model model, int productId) {
        ProductInfo productInfo = productService.queryProductByProductId(productId);
        Date startTime = productInfo.getStartTime();
        Date endTime = productInfo.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (startTime != null) {
            startTimeString = dateFormat.format(startTime);
        }
        if (endTime != null) {
            endTimeString = dateFormat.format(endTime);
        }

        model.addAttribute("productInfo", productInfo);
        model.addAttribute("startTimeString", startTimeString);
        model.addAttribute("endTimeString", endTimeString);
        return "/skProductInfo/updateProduct";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(ProductInfo productInfo) {
        productService.updateProduct(productInfo);
        return "redirect:listSkProduct";
    }

    @RequestMapping(value = "/toUpdateProductState")
    public String toUpdateProductState(Model model, int productId) {
        ProductInfo productInfo = productService.queryProductByProductId(productId);
        Date startTime = productInfo.getStartTime();
        Date endTime = productInfo.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (startTime != null) {
            startTimeString = dateFormat.format(startTime);
        }
        if (endTime != null) {
            endTimeString = dateFormat.format(endTime);
        }

        model.addAttribute("productInfo", productInfo);
        model.addAttribute("startTimeString", startTimeString);
        model.addAttribute("endTimeString", endTimeString);
        return "/skProductInfo/auditSkProduct";
    }


    @RequestMapping(value = "/updateProductState", method = RequestMethod.POST)
    public String updateProductState(int id, int state) {
        productService.updateProductState(id, state);
        return "redirect:listSkProduct";
    }
}
