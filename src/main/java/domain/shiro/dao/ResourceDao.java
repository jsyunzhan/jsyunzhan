package domain.shiro.dao;

import domain.shiro.entity.ParamEntity;
import domain.shiro.entity.ResourceEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源表dao
 */
@Repository
public interface ResourceDao {
    /**
     * 获取资源信息
     * @param roleId 角色id
     * @return 资源信息
     */
    List<ResourceEntity> getResourceInfoByRoleId(Long roleId);

    /**
     * 获取所有的资源
     * @return 资源信息
     */
    List<ResourceEntity> resourceList();

    /**
     * 根据roleId删除映射表资源
     * @param roleId 角色id
     * @param loginId 当前登录id
     * @return Integer
     */
    Integer deleteResourceByRoleId(@Param("roleId") Long roleId,@Param("loginId") Long loginId);


    /**
     * 添加授权
     * @param resourceId 资源id
     * @param roleId 角色id
     * @param loginId 当前登录id
     */
    Integer addAuthorization(@Param("resourceId") Long resourceId,@Param("roleId") Long roleId,@Param("createUserId") Long loginId);

    /**
     * 获取参数表参数
     * @param paramType 参数类型
     * @return List<ParamEntity>
     */
    List<ParamEntity> getParams(String paramType);
}
