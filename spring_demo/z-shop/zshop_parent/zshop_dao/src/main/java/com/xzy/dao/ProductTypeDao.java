package com.xzy.dao;

import com.xzy.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeDao {
    /*
    查询所有商品类型信息
     */
    public List<ProductType> selectAll();

    /**
     * 根据商品id查询商品类型信息
     */
    public ProductType selectById(int id);


    /**
     * 添加商品信息
     */
    public void insert(@Param("name") String name, @Param("status") int status);

    /**
     * 根据name查询商品类型信息
     */
    public ProductType selectByName(String name);
    /**
     * 根据id修改商品名字
     */
    public void updataName(@Param("id") int id,@Param("name") String name);

    /**
     * 根据id修改商品状态
     */
    public void updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id修改商品类型
     */
    public void deleteById(int id);
}
