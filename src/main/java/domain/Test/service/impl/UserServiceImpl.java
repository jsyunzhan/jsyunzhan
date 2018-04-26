package domain.Test.service.impl;

import domain.Test.dao.UserDao;
import domain.Test.entity.UserEntity;
import domain.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mark.chen on 2018/04/26.
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserEntity getUser() {
        return userDao.getUser();
    }
}
