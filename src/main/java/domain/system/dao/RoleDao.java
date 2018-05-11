package domain.system.dao;

import domain.system.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 新增
     * @param roleEntity 新增实体
     * @return Integer
     */
    Integer addRole(RoleEntity roleEntity);

    /*
    判断是否重复
     */
    Integer checkRoleName(@Param("id") Long id,@Param("roleName") String roleName);
}
