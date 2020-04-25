package com.hustmcx.mall_seckill.controller;

import com.hustmcx.mall_seckill.model.Order;
import com.hustmcx.mall_seckill.model.ProductInfo;
import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.model.User;
import com.hustmcx.mall_seckill.service.OrderService;
import com.hustmcx.mall_seckill.service.ProductService;
import com.hustmcx.mall_seckill.service.pay.AliPayService;
import com.hustmcx.mall_seckill.service.pay.CardService;
import com.hustmcx.mall_seckill.service.pay.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    WeChatService weChatService;
    @Autowired
    CardService cardService;
    @Autowired
    AliPayService aliPayService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @RequestMapping("/payOrder")
    public String payOrder(Order order) {
        Date now = new Date();
        order.setCreateTime(now);
        int payStatus = 1;
        order.setPayStatus(payStatus);
        String transactionSerial = UUID.randomUUID().toString();
        order.setTransactionSerial(transactionSerial);
        orderService.insertOrder(order);
        return "redirect:/pageHome/home";
    }

    @RequestMapping("/toPayOrder")
    public String toPayOrder(HttpServletRequest request, int productId, int orderAmount) {
        ProductInfo productInfo = productService.queryProductByProductId(productId);
        request.setAttribute("productInfo", productInfo);
        request.setAttribute("orderAmount", orderAmount);
        int payAmount = orderAmount * productInfo.getKillPrice();
        request.setAttribute("payAmount", payAmount);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            request.setAttribute("userId", user.getId());
        } else {
            request.setAttribute("errorInfo", "未登录");
            return "redirect:/userRegisterLogin/toLogin";//dasdasdadawwadwadwadaw
        }
        return "/order/payOrder";
    }

    @RequestMapping("/queryOrderByUserId")
    public String queryOrderByUserId(HttpServletRequest request) {
        String returnUrl = "/order/listOrder";
        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("user");
        if (user != null) {
            List<Order> list = orderService.queryOrderByUserId(user.getId());
            request.setAttribute("list", list);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "redirect:/userRegisterLogin/toLogin";
        }
        return returnUrl;
    }

    @RequestMapping("queryOrderBySellerId")
    public String queryOrderBySellerId(HttpServletRequest request) {
        String returnUrl = "/order/listOrderWithSeller";
        HttpSession sess = request.getSession();
        Seller seller = (Seller) sess.getAttribute("seller");
        if (seller != null) {
            List<Order> list = orderService.queryOrderBySellerId(seller.getId());
            request.setAttribute("list", list);
        } else {
            request.setAttribute("errorInfo", "未登陆");
            returnUrl = "redirect:/sellerRegisterLogin/toLogin";
        }

        return returnUrl;
    }

    @RequestMapping("toPayWithOrder")
    public String toPayWithOrder(Model model, int id, String transactionSerial, int payAmount) {
        model.addAttribute("id", id);
        model.addAttribute("transactionSerial", transactionSerial);
        model.addAttribute("payAmount", payAmount);
        return "/order/payReal";

    }

    /**
     * @param payType           1代表支付宝  2代表微信  3代表银联
     * @param transactionSerial
     * @param payAmount
     * @return
     */
    @RequestMapping(value = "payWithOrder", method = RequestMethod.POST)
    public String payWithOrder(int payType, int id, String transactionSerial, int payAmount) {
        int payStatus = 2;
        if (payType == 1) {//1代表支付宝
            payStatus = aliPayService.payWithOrder(transactionSerial, payAmount);
        } else if (payType == 2) {//2代表微信
            payStatus = weChatService.payWithOrder(transactionSerial, payAmount);
        } else if (payType == 3) {//3是代表银联
            payStatus = cardService.payWithOrder(transactionSerial, payAmount);
        }
        if (payStatus == 1) {
            orderService.updateOrderPayStatusById(2, id, payType);
        }
        return "redirect:queryOrderByUserId";

    }

    @RequestMapping(value = "applyRefund", method = {RequestMethod.POST, RequestMethod.GET})
    public String applyRefund(HttpServletRequest request, String orderId, String payType) {
        System.out.println(orderId + "  " + payType);
        String returnUrl = "redirect:queryOrderByUserId";
        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("user");
        if (user != null) {
            orderService.updateOrderPayStatusById(4, Integer.valueOf(orderId), Integer.valueOf(payType));
            System.out.println("更新了");
        } else {
            request.setAttribute("errorInfo", "未登陆");
            returnUrl = "redirect:/userRegisterLogin/toLogin";
        }
        return returnUrl;
    }

    @RequestMapping("auditRefund")
    public String auditRefund(HttpServletRequest request, String transactionSerial, int payAmount, int orderId, int payType, int payStatus) {
        String returnUrl = "redirect:queryOrderBySellerId";
        HttpSession sess = request.getSession();
        Seller seller = (Seller) sess.getAttribute("seller");
        if (seller != null) {
            if (payStatus == 3) {
                int payStatusTemp = 2;
                if (payType == 1) {//1代表支付宝
                    payStatusTemp = aliPayService.refundWithOrder(transactionSerial, payAmount);
                } else if (payType == 2) {//2代表微信
                    payStatusTemp = weChatService.refundWithOrder(transactionSerial, payAmount);
                } else if (payType == 3) {//3是代表银联
                    payStatusTemp = cardService.refundWithOrder(transactionSerial, payAmount);
                }
                if (payStatusTemp == 1) {
                    orderService.updateOrderPayStatusById(payStatus, orderId, payType);
                }

            } else if (payStatus == 5) {
                orderService.updateOrderPayStatusById(payStatus, orderId, payType);
            }
        } else {
            request.setAttribute("errorInfo", "未登陆");
            returnUrl = "redirect:/sellerRegisterLogin/toLogin";
        }

        return returnUrl;
    }


}
