package com.xzy.service.impl;

import com.xzy.Exception.ProductTypeExistException;
import com.xzy.constant.ProductTypeConstant;
import com.xzy.dao.ProductTypeDao;
import com.xzy.pojo.ProductType;
import com.xzy.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl  implements ProductTypeService {
    @Autowired
    private ProductTypeDao productTypeDao;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<ProductType> findtAll() {
        return productTypeDao.selectAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public ProductType findById(int id) {
        return productTypeDao.selectById(id);
    }

    @Override
    public void add(String name) throws ProductTypeExistException {
        ProductType productType = productTypeDao.selectByName(name);
        if(productType != null){
            throw new ProductTypeExistException("商品类型已经存在");
        }
        productTypeDao.insert(name, ProductTypeConstant.PRODUCT_TYPE_ENABLE);
    }

    @Override
    public void modifyName(int id, String name) {

    }

    @Override
    public void modifyStatus(int id, int status) {

    }

    @Override
    public void removeById(int id) {

    }
}
