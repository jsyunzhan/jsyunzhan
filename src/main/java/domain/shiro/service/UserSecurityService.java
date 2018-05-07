package domain.shiro.service;

import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.ResourceEntity;

import java.util.List;

public interface UserSecurityService {

    /**
     * 获取用户信息
     * @param loginName 登录名
     * @return AccountEntity 用户信息
     */
    AccountEntity accoutInfo(String loginName);

    /**
     * 获取资源
     * @param roleId 角色id
     * @return List<ResourceEntity> 资源信息
     */
    List<ResourceEntity>  getResourceInfoByRoleId(Long roleId);
}
