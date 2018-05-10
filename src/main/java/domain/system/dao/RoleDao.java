package domain.system.dao;

import domain.system.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 获取总数
     * @param roleEntity 查询实体
     * @return Integer
     */
    Integer roleCount(RoleEntity roleEntity);

    /**
     * 获取分页信息
     * @param roleEntity 查询实体
     * @return
     */
    List<RoleEntity> roleListInfo(RoleEntity roleEntity);
}
