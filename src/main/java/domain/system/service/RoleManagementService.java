package domain.system.service;

import domain.shiro.entity.PageQueryResult;
import domain.system.entity.RoleEntity;

public interface RoleManagementService {
    /**
     * 角色管理分页
     * @param roleEntity 查询实体
     * @return PageQueryResult
     */
    PageQueryResult roleListInfo(RoleEntity roleEntity);

    Boolean addRole(RoleEntity roleEntity);
}
