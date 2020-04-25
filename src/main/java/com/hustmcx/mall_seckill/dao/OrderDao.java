package com.hustmcx.mall_seckill.dao;

import com.hustmcx.mall_seckill.model.Order;
import com.hustmcx.mall_seckill.vo.order.OrderVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {

    /**
     * INSERT INTO `mall_seckill`.`order`
     * (`id`, `product_id`, `pay_amount`, `user_id`, `seller_id`, `create_time`, `pay_status`, `receiving_address`, `receiving_phone`, `receiving_name`, `transaction_serial`, `order_amount`)
     */
    String TABLE_NAME = " skOrder ";
    String INSERT_FIELDS = " product_id, pay_amount, user_id, seller_id, create_time, pay_status, receive_address, receive_phone, receive_name, transaction_serial, order_amount, pay_type ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = false, resultType = java.lang.Integer.class)
    @Insert({"insert into ", TABLE_NAME, " ( ", INSERT_FIELDS, " ) values ( #{productId},#{payAmount},#{userId},#{sellerId},#{createTime},#{payStatus},#{receiveAddress},#{receivePhone},#{receiveName},#{transactionSerial},#{orderAmount},#{payType} )"})
    void insertOrder(Order order);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where user_id = #{userId}"})
    List<Order> queryOrderByUserId(int userId);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where seller_id = #{sellerId}"})
    List<Order> queryOrderBySellerId(int sellerId);


    //    paystatus=#{constomOrder.paystatus},paytype=#{constomOrder.paytype}
//    where id=#{constomOrder.id}
    @Update({"update", TABLE_NAME, " set " +
            "pay_status=#{customOrder.payStatus}, pay_type=#{customOrder.payType} " +
            "where id = #{customOrder.id}"})
    void updateOrderPayStatusById(OrderVo orderVo);
}
