package domain.shiro.service.impl;

import domain.shiro.dao.AccountDao;
import domain.shiro.entity.AccountEntity;
import domain.shiro.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UserSecurityService{

    private final AccountDao accountDao;

    @Autowired
    public UserSecurityServiceImpl(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public AccountEntity accoutInfo(String username) {
        return accountDao.accoutInfo(username);
    }
}
