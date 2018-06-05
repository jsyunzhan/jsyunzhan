package domain.shiro.service;

import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.ParamEntity;
import domain.shiro.entity.ResourceEntity;

import java.util.List;

/**
 * 用户认证和获取资源Service
 */
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

    /**
     * 获取参数表参数
     * @param paramType 参数类型
     * @return List<ParamEntity>
     */
    List<ParamEntity> getParams(String paramType);
}
