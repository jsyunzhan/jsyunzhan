package domain.shiro.service.impl;

import domain.shiro.dao.AccountDao;
import domain.shiro.dao.ResourceDao;
import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.ParamEntity;
import domain.shiro.entity.ResourceEntity;
import domain.shiro.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户登录验证和获取起源service
 */
@Service
public class UserSecurityServiceImpl implements UserSecurityService{

    private final AccountDao accountDao;
    private final ResourceDao resourceDao;

    @Autowired
    public UserSecurityServiceImpl(AccountDao accountDao,ResourceDao resourceDao){
        this.accountDao = accountDao;
        this.resourceDao = resourceDao;
    }

    @Override
    public AccountEntity accoutInfo(String loginName) {
        return accountDao.accoutInfo(loginName);
    }

    @Override
    public List<ResourceEntity> getResourceInfoByRoleId(Long roleId) {
        return resourceDao.getResourceInfoByRoleId(roleId);
    }

    @Override
    public List<ParamEntity> getParams(String paramType) {
        return resourceDao.getParams(paramType);
    }
}
