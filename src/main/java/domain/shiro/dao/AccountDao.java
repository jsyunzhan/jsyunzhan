package domain.shiro.dao;

import domain.shiro.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    AccountEntity accoutInfo(String username);
}
