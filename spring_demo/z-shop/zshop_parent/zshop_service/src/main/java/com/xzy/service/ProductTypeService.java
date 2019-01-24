package com.xzy.service;

import com.xzy.Exception.ProductTypeExistException;
import com.xzy.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeService {
    /*
    查询所有商品类型信息
     */
    public List<ProductType> findtAll();

    /**
     * 根据商品id查询商品类型信息
     */
    public ProductType findById(int id);


    /**
     * 添加商品信息
     * 如果商品已经存在的话，则抛出异常
     * 如果不存在，则进行添加的操作
     */
    public void add( String name) throws ProductTypeExistException;

    /**
     * 根据id修改商品名字
     */
    public void modifyName( int id, String name);

    /**
     * 根据id修改商品状态
     */
    public void modifyStatus(int id,int status);

    /**
     * 根据id修改商品类型
     */
    public void removeById(int id);
}
