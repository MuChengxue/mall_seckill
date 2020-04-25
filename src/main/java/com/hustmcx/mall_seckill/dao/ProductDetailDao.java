package com.hustmcx.mall_seckill.dao;

import com.hustmcx.mall_seckill.model.ProductDetail;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductDetailDao {

    String TABLE_NAME = " product_detail ";
    String INSERT_FIELDS = " product_id, seller_id, product_place, product_name, brand_name, product_weight, specification, detail_pic  ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = false, resultType = java.lang.Integer.class)
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{productId},#{sellerId},#{productPlace},#{productName},#{brandName},#{productWeight},#{specification},#{detailPic})"})
    void insertProductDetail(ProductDetail productDetail);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where product_id = #{productId}"})
    ProductDetail queryProductDetailByProductId(int productId);

    @Update({"update", TABLE_NAME, " set " +
            "product_place=#{productPlace}, product_name=#{productName}, brand_name=#{brandName},  " +
            "product_weight=#{productWeight}, specification=#{specification}, detail_pic=#{detailPic} " +
            "where product_id = #{productId}"})
    void updateProductDetail(ProductDetail productDetail);

}
