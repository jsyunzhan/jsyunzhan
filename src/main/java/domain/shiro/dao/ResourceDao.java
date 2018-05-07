package domain.shiro.dao;

import domain.shiro.entity.ResourceEntity;
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
}
