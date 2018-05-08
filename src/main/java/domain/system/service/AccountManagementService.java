package domain.system.service;

import domain.shiro.entity.AccountEntity;

/**
 * 用户管理接口
 */
public interface AccountManagementService {

    Boolean addAccount(AccountEntity accountEntity);
}
