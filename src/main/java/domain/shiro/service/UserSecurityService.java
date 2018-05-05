package domain.shiro.service;

import domain.shiro.entity.AccountEntity;

public interface UserSecurityService {

    AccountEntity accoutInfo(String username);
}
