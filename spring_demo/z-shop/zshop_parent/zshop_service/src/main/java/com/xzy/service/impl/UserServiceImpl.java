package com.xzy.service.impl;

import com.xzy.Exception.SysuserExistException;
import com.xzy.dao.UserDao;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findById(Long userId) {
        return userDao.findByID(userId);
    }

    @Override
    public Integer insertUser(User sysuser) throws SysuserExistException {
        User user =  userDao.selectByName(sysuser.getUsername());
        if(user != null){
            throw  new SysuserExistException("用户已经存在");
        }
        return userDao.insertUser(sysuser);
    }

    @Override
    public User selectByName(String username) {
        return userDao.selectByName(username);
    }
}
