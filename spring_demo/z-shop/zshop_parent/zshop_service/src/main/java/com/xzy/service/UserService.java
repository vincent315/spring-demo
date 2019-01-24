package com.xzy.service;

import com.xzy.Exception.SysuserExistException;
import com.xzy.pojo.User;

public interface UserService {
    /**
     * 根据id查询用户
     */
    User findById(Long userId);

    /**
     * 注册用户
     */
    Integer insertUser(User sysuser) throws SysuserExistException;

    /**
     * 根据用户名查询用户
     */
    User selectByName(String username);
}
