package domain.system.service.impl;

import domain.shiro.dao.AccountDao;
import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.PageQueryResult;
import domain.system.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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



    @Override
    public PageQueryResult accountListInof(AccountEntity accountEntity) {

        final PageQueryResult pageQueryResult = new PageQueryResult();
        final Integer count = accountDao.accountCount(accountEntity );
        List<AccountEntity> accountEntityList = newArrayList();
        if (count > 0){
            accountEntityList = accountDao.accountListInfo(accountEntity);
        }


        pageQueryResult.setRows(accountEntityList);
        pageQueryResult.setTotal(count);

        return pageQueryResult;
    }
}
