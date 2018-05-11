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

    /*
    新增
     */
    Boolean addRole(RoleEntity roleEntity);

    /*
    判断是否roleName是否重复
     */
    Boolean checkRoleName(Long id, String roleName);
}
