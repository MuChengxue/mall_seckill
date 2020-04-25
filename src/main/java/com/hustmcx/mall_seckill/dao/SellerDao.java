package com.hustmcx.mall_seckill.dao;

import com.hustmcx.mall_seckill.model.Seller;
import com.hustmcx.mall_seckill.vo.seller.SellerVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SellerDao {

    String TABLE_NAME = " seller ";
    String INSERT_FIELDS = " name, shop_name, account, password, scope ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = false, resultType = java.lang.Integer.class)
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{name},#{shopName},#{account},#{password},#{scope})"})
    void insertSeller(Seller seller);

    //@Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    //User selectById(int id);
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
    Seller getSellerById(int id);

    @Update({"update", TABLE_NAME, " set " +
            "name=#{name}, shop_name=#{shopName}, " +
            "account=#{account}, password=#{password}, " +
            "scope=#{scope}" +
            "where id = #{id}"})
    void updateSeller(Seller seller);

    @Delete({"delete from ", TABLE_NAME, "where id=#{id}"})
    void deleteSellerById(int id);

    /**
     * get所有的Seller
     *
     * @param sellerVo
     * @return
     */
    List<Seller> querySellerByVo(SellerVo sellerVo);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where account = #{account}"})
    Seller getSellerByAccount(String account);
}
