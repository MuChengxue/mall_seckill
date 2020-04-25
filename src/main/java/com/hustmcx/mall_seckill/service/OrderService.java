package com.hustmcx.mall_seckill.service;

import com.hustmcx.mall_seckill.dao.OrderDao;
import com.hustmcx.mall_seckill.model.Order;
import com.hustmcx.mall_seckill.vo.order.CustomOrder;
import com.hustmcx.mall_seckill.vo.order.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public void insertOrder(Order order) {
        orderDao.insertOrder(order);
    }

    public List<Order> queryOrderByUserId(int userId) {
        return orderDao.queryOrderByUserId(userId);
    }


    public List<Order> queryOrderBySellerId(int sellerId) {
        return orderDao.queryOrderBySellerId(sellerId);
    }

    public void updateOrderPayStatusById(int payStatus, int id, int payType) {
        OrderVo orderVo = new OrderVo();
        CustomOrder customOrder = new CustomOrder();
        customOrder.setPayStatus(payStatus);
        customOrder.setId(id);
        customOrder.setPayType(payType);
        orderVo.setCustomOrder(customOrder);
        orderDao.updateOrderPayStatusById(orderVo);
    }
}
