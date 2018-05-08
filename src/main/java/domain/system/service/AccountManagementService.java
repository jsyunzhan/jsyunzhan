package domain.system.service;

import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.PageQueryResult;

/**
 * 用户管理接口
 */
public interface AccountManagementService {

    /**
     * 添加用户
     * @param accountEntity 添加实体
     * @return Boolean
     */
    Boolean addAccount(AccountEntity accountEntity);


    /**
     *
     * @param  accountEntity
     * @return PageQueryResult
     */
    PageQueryResult accountListInof(AccountEntity accountEntity);
}
