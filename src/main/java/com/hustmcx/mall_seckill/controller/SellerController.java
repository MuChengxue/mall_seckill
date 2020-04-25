package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.service.SellerService;
import com.hustmcx.mall_seckill.vo.seller.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @RequestMapping(path = "/toAdd")
    public String toAdd() {
        return "/seller/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCommit(Seller seller) {
        sellerService.insertSeller(seller);
        System.out.println(seller);
//        System.out.println(System.currentTimeMillis());
        return "redirect:queryByVo";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, int id) {
        Seller seller = sellerService.getSellerById(id);
//        System.out.println(seller);
        model.addAttribute("seller", seller);
        return "/seller/update";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String update(Seller seller) {
//        System.out.println("update");
        sellerService.updateSeller(seller);
//        System.out.println(seller);
        return "redirect:queryByVo";
    }

    @RequestMapping("/delete")
    //不加@ResponseBody就去找HTML页面去了，可真烦
    public String delete(int id) {
        sellerService.deleteSellerById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("/query")
    public String query(Model model, int id) {
        Seller seller = sellerService.getSellerById(id);
        System.out.println(seller);
        model.addAttribute("seller", seller);
        return "seller/view";
    }

    @RequestMapping("/queryByVo")
    public String queryByVo(Model model, SellerVo sellerVo) {
        List<Seller> list = sellerService.querySellerByVo(sellerVo);
        model.addAttribute("sellerList", list);
        return "seller/list";
    }
}
