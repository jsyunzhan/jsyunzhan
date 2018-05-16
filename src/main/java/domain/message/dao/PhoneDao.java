package domain.message.dao;

import domain.message.entity.PhoneEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneDao {
    /**
     * 手机消息管理总数
     * @param phoneEntity 分页总是
     * @return Integer
     */
    Integer phoneMessCount(PhoneEntity phoneEntity);

    /**
     * 手机消息管理，分页集合
     * @param phoneEntity 分页实体
     * @return List<PhoneEntity>
     */
    List<PhoneEntity> phoneMessList(PhoneEntity phoneEntity);

    /**
     * 手机公告新增
     * @param phoneEntity 新增实体
     * @return Boolean
     */
    Integer phoneMessAdd(PhoneEntity phoneEntity);

    /**
     * 手机公告修改
     * @param phoneEntity 修改实体
     * @return Boolean
     */
    Integer phoneMessEdit(PhoneEntity phoneEntity);

    /**
     * 手机公告删除
     * @param id id
     * @param loginId 当前登录id
     * @return Integer
     */
    Integer phoneMessDelete(@Param("id") Long id,@Param("updateUserId") Long loginId);
}
