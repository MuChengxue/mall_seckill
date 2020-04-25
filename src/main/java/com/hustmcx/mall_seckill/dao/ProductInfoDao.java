package com.hustmcx.mall_seckill.dao;

import com.hustmcx.mall_seckill.model.ProductInfo;
import com.hustmcx.mall_seckill.vo.productInfo.ProductInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductInfoDao {
    String TABLE_NAME = " product_info ";
    String INSERT_FIELDS = " product_id, product_title, product_pic, original_price, kill_price, seller_id, " +
            " apply_time, audit_time, audit_state, start_time,  end_time, product_count, " +
            " store_count, description ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = false, resultType = java.lang.Integer.class)
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{productId},#{productTitle},#{productPic},#{originalPrice},#{killPrice}," +
                    "#{sellerId},#{applyTime},#{auditTime},#{auditState},#{startTime}," +
                    "#{endTime},#{productCount},#{storeCount},#{description})"})
    void applySkProduct(ProductInfo productInfo);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where product_id = #{productId}"})
    ProductInfo queryProductByProductId(int id);

    @Delete({"delete from ", TABLE_NAME, "where product_id=#{product_id}"})
    void deleteProductByProductId(int productId);

    @Update({"update", TABLE_NAME, " set " +
            "product_id=#{productId}, product_title=#{productTitle}, product_pic=#{productPic}, original_price=#{originalPrice}, " +
            "kill_price=#{killPrice}, seller_id=#{sellerId}, apply_time=#{applyTime}, audit_time=#{auditTime}, " +
            "audit_state=#{auditState}, start_time=#{startTime}, end_time=#{endTime}, product_count=#{productCount}, " +
            "store_count=#{storeCount}, description=#{description} " +
            "where id = #{id}"})
    void updateProduct(ProductInfo productInfo);

    @Update({"update", TABLE_NAME, " set " +
            "audit_state=#{customProduct.auditState} " +
            "where id = #{customProduct.id}"})
    void updateProductState(ProductInfoVo productInfoVo);

    List<ProductInfo> listProduct(ProductInfoVo productInfoVo);


}
