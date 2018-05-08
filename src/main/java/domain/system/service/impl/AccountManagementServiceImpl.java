package domain.system.service.impl;

import domain.shiro.dao.AccountDao;
import domain.shiro.entity.AccountEntity;
import domain.system.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountManagementServiceImpl implements AccountManagementService{
    private final AccountDao accountDao;

    @Autowired
    public AccountManagementServiceImpl(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public Boolean addAccount(AccountEntity accountEntity) {
        return accountDao.addAccout(accountEntity) > 0;
    }
}
