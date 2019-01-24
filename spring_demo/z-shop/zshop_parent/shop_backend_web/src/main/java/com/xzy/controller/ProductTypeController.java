package com.xzy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.Exception.ProductTypeExistException;
import com.xzy.constant.PageInationConstant;
import com.xzy.constant.ResponseStatusConstant;
import com.xzy.pojo.ProductType;
import com.xzy.service.ProductTypeService;
import com.xzy.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    @RequestMapping("/findAll")
    public String findAll(Integer pageNum,Map map){
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum = PageInationConstant.PAGE_NUM;
        }
        //设置分页
        PageHelper.startPage(pageNum,PageInationConstant.PAGE_SIZE);
        //查询所有商品类型
        List<ProductType> productTypes = productTypeService.findtAll();

        //将查询所有的数据进行分页设置，封装PageInfo对象
        PageInfo<ProductType> pageInfo = new PageInfo<ProductType>(productTypes);
        map.put("pageInfo",pageInfo);
        return "productTypeManager";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(String name){
        ResponseResult responseResult = new ResponseResult();
        try {
            productTypeService.add(name);
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
            responseResult.setMessage("添加成功");
        } catch (ProductTypeExistException e) {
            e.printStackTrace();
            responseResult.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            responseResult.setMessage(e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ResponseResult findById(int id){
        ProductType productType = productTypeService.findById(id);
        return ResponseResult.success(productType);
    }



    public static void test(){
        System.out.println("adad");
    }

    public static void main(String[] args) {
        test();
    }
}
