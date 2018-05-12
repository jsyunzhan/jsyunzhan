package domain.shiro.dao;

import domain.shiro.entity.AccountEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表dao
 */
@Repository
public interface AccountDao {
    /**
     * 获取用户信息-用于登录
     * @param loginName 登录名
     * @return AccountEntity 用户信息
     */
    AccountEntity accoutInfo(String loginName);

    /**
     * 新增用户
     * @param accountEntity 用户实体
     * @return Integer
     */
    Integer addAccout(AccountEntity accountEntity);

    /**
     * 获取总数
     * @param accountEntity 查询实体
     * @return Integer
     */
    Integer accountCount(AccountEntity accountEntity);

    /**
     * 获取集合总数
     * @param accountEntity 查询实体
     * @return List<AccountEntity>
     */
    List<AccountEntity> accountListInfo(AccountEntity accountEntity);

    /**
     * 用户添加
     * @param accountEntity 添加实体
     * @return Integer
     */
    Integer accountAdd(AccountEntity accountEntity);
}
