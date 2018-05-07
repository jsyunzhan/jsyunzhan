package domain.shiro.dao;

import domain.shiro.entity.AccountEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户表dao
 */
@Repository
public interface AccountDao {
    /**
     * 获取用户信息
     * @param loginName 登录名
     * @return AccountEntity 用户信息
     */
    AccountEntity accoutInfo(String loginName);
}
